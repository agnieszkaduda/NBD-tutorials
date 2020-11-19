var mapFunction = function () {
    emit(this.sex, {
        weight: parseFloat(this.weight),
        height: parseFloat(this.height),
        counter: 1
        });
};

var reduceFunction = function (key, values) {
    var reducedValue = {weight: 0, height: 0, counter: 0};
    
    for(var i = 0; i < values.length; i++) {
        reducedValue.weight += values[i].weight;
        reducedValue.height += values[i].height;
        reducedValue.counter += values[i].counter;
    }
    return reducedValue;
};

var finalizeFunction = function (key, reducedValue) {
    var avgWeightHeightPerGender = {
        avgHeight: reducedValue.height/reducedValue.counter,
        avgWeight: reducedValue.weight/reducedValue.counter
    }
    return avgWeightHeightPerGender;
};

db.people.mapReduce(mapFunction, reduceFunction, {finalize: finalizeFunction, out: "avgWeightHeightPerGender"})
printjson(db.avgWeightHeightPerGender.find().toArray());
