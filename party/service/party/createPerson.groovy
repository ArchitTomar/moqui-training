// 1. Required validation
if (!partyId || !firstName || !lastName) {
    ec.message.addError("partyId, firstName, and lastName are required")
    return
}

// 2. Party exists or not
def party = ec.entity.find("party.Party")
        .condition("partyId", partyId)
        .one()

if (!party) {
    ec.message.addError("No Party found with partyId: ${partyId}")
    return
}

// 3. Create Person object
def person = ec.entity.makeValue("party.Person")

// 4. Set all fields from input
person.setFields(context, true, null, null)

// 5. Force link with Party
person.partyId = partyId

// 6. Insert into DB
person.create()

// 7. Success message
responseMessage = "Person ${firstName} ${lastName} created successfully!"
