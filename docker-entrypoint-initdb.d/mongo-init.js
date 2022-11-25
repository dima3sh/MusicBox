print('Start #################################################################');
db = db.getSiblingDB("music_box_db");

db.createUser({
    user: "root",
    pwd: "root",
    roles: [
        {
            role: "readWrite",
            db: "music_box_db",
        },
    ],
});

db.createCollection('music');