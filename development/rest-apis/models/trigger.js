var mongoose = require('mongoose');

var Trigger = mongoose.model('Trigger', {
    userId: {
        type: String
    },
    tripId: {
        type: Number
    },
    beaconTrigger: {
        type: String,
        required: true,
        trim: true,
        minlength: 1
    }
});

module.exports = {Trigger}
