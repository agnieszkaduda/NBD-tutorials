printjson(db.people.aggregate([
    {
        "$match": { "nationality": "Poland", "sex": "Female"}
    },
    { 
        "$unwind": "$credit"
    },
    {
       "$group":
        {
            "_id": "$credit.currency",
            "avg_balance": {"$avg": {"$toDouble": "$credit.balance"}},
            "total_balance": {"$sum": {"$toDouble": "$credit.balance"}}
        }
    }
]).toArray())