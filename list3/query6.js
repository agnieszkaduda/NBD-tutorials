db.people.insert({
        "sex" : "Female", 
        "first_name" : "Agnieszka", 
        "last_name" : "Duda", 
        "job" : "Devops Engineer", 
        "email" : "s21998@pjwstk.edu.pl", 
        "location" : {
            "city" : "Warsaw", 
            "address" : {
                "streetname" : "Kwiatowa", 
                "streetnumber" : "1"
            }
        }, 
        "description" : "blablabla", 
        "height" : "170", 
        "weight" : "55", 
        "birth_date" : "1997-06-23T09:00:00Z", 
        "nationality" : "Poland", 
        "credit" : [
            {
                "type" : "jcb", 
                "number" : "12345678998765432123456789", 
                "currency" : "PLN", 
                "balance" : "9999999.99"
            }
        ]
    })