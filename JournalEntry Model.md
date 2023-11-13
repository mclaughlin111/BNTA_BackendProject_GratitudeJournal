#RESTful Routes

## JournalEntry Model

### GET Mapping

* Display all journal entries - `"/journal-entries"`

* Include optional path variable to display by journal entry ID - `"/{id}"`
* Response entity returns a List of all journal entries back to the user, or specific journal by ID.
* Return `HTTPStatus.OK`

### POST Mapping

* Include request body. Use a EntryDTO to get the UserId- 
	* `"userId" = 1,`
	* `"content" = "I am grateful.",`
	* `"weekDay" = "Monday",`
	* `"moodRating = "Great"`
* Response entity returns the posted journal entry back to the user
* Return `HTTPStatus.CREATED`

	
### PATCH Mapping

* Include path variables to select JournalEntry ID that we want to update - `"/{id}`
* Include request body of a journalEntry object to input information to be updated.
* Response entity returns the updated journal entry back to the user.
* Return `HTTPStatus.OK`


### DELETE Mapping

* Include path variable to select JournalEntry ID that we want to delete - `"/{id}`.
* Response entity returns JournalEntry ID that we deleted.
* Return `HTTPStatus.OK`

