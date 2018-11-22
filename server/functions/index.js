const functions = require('firebase-functions');

const cors = require('cors')({ origin: true });

const admin = require('firebase-admin');
admin.initializeApp();

const sightsDBPath = '/sights';

const formSightUpdates = (req) => {
    const newName = req.body.name
    const newLocation = req.body.location
    const newDescription = req.body.description

    var updates = {};

    if (newName) {
        updates['/name'] = newName;
    }
    if (newLocation) {
        updates['/location'] = newLocation;
    }
    if (newDescription) {
        updates['/description'] = newDescription;
    }

    return updates;
}

const selectSights = (res, condition = (sight) => { return true; }) => {
    let sights = [];
    return admin.database().ref(sightsDBPath).on('value', (snapshot) => {
        snapshot.forEach((sight) => {
            if (condition(sight)) {
                sights.push({
                    id: sight.key,
                    name: sight.val().name,
                    location: sight.val().location,
                    description: sight.val().description
                });
            }
        });
        res.status(200).json(sights);
    }, (error) => {
        res.status(error.code).json({
            message: `Something went wrong. ${error.message}`
        });
    });
}

exports.insertSight = functions.https.onRequest((req, res) => {
    return cors(req, res, () => {
        if (req.method !== 'POST') {
            return res.status(405).json({
                message: 'Not allowed'
            });
        }

        const name = req.body.name
        const location = req.body.location

        if (!name || !location) {
            return res.status(404).json({
                message: 'Name and location are required.'
            });
        }

        const description = req.body.description ? req.body.description : ''
        
        admin.database().ref(sightsDBPath).push({ name, location, description });

        selectSights(res);
    })
})

exports.deleteSight = functions.https.onRequest((req, res) => {
    return cors(req, res, () => {
        if (req.method !== 'DELETE') {
            return res.status(405).json({
                message: 'Not allowed'
            });
        }

        const id = req.query.id;
        if (!id) {
            return res.status(404).json({
                message: 'No id to delete by is specified.'
            });
        }

        admin.database().ref(sightsDBPath + `/${id}`).remove();

        selectSights(res);
    })
})

exports.selectAllSights = functions.https.onRequest((req, res) => {
    return cors(req, res, () => {
        if (req.method !== 'GET') {
            return res.status(405).json({
                message: 'Not allowed'
            });
        }

        selectSights(res);
    })
})

exports.selectSightsByName = functions.https.onRequest((req, res) => {
    return cors(req, res, () => {
        if (req.method !== 'GET') {
            return res.status(405).json({
                message: 'Not allowed'
            });
        }

        const name = req.query.name;
        if (!name) {
            return res.status(404).json({
                message: 'No name to search by is specified.'
            });
        }

        selectSights(res, (sight) => { return sight.val().name === name || sight.val().name.includes(name); });

    })
})

exports.updateSight = functions.https.onRequest((req, res) => {
    return cors(req, res, () => {
        if (req.method !== 'POST') {
            return res.status(405).json({
                message: 'Not allowed'
            });
        }

        const id = req.query.id;
        if (!id) {
            return res.status(404).json({
                message: 'No id to update by is specified.'
            });
        }

        const updates = formSightUpdates(req);

        if (Object.keys(updates).length === 0) {
            return res.status(404).json({
                message: 'No new values for an update found.'
            });
        }

        admin.database().ref(sightsDBPath + `/${id}`).update(updates);

        selectSights(res);
    })
})
