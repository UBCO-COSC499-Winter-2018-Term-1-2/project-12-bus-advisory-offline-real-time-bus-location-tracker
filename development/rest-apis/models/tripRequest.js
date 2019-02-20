var mongoose = require('mongoose');

var TripRequest = mongoose.model('TripRequest', {
    userId: {
        type: String
    },
    tripId: {
        type: Number
    },
    busId: {
        type: String
    },
    busStop: {
        type: String,
        required: true
    },
    reqestedTime: Number,
    reminderTime: {
        type: Number,
        required: true
    }
});

module.exports = {TripRequest}
