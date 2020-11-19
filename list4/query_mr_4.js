var mapFunction = function () {
    emit(this.nationality, {
        height: parseFloat(this.height),
        weight: parseFloat(this.weight)
        });
};

var reduceFunction = function(key, values) {
	var bmi = []

    for(var i = 0; i < values.length; i++) {
        bmi.push(values[i].weight/((values[i].height/100)*(values[i].height/100)))   
    };
    return bmi;
};

var finalizeFunction = function(key, bmi) {
    var result = {
      avgBmi: Array.sum(bmi)/bmi.length,
      minBmi: Math.min(...bmi),
      maxBmi: Math.max(...bmi)  
    };
    return result;
};

db.people.mapReduce(mapFunction, reduceFunction, {finalize: finalizeFunction, out: "bmi"});
printjson(db.bmi.find().toArray());