# Gratitude Journal 📒

## MVP - Journal

* Add a Journal Entry
	* Enter day of the week 
	* Input mood rating	for the day
	* Record a gratitude entry in the journal
	

* Display all Journal Entries
* Update Journal Entry
* Delete Journal Entry


## Extension I - User 
* Create a User
* Update User Credentials
* Delete User

## Extension II - Filtering

* Filter Journal Entries by `Weekday`
* Filter Journal Entries by `userId`
* Filter Journal Entries by `moodRating`

## Extension III - up-to-5 Journal Entries

* Upon 5 Journal Entries for a single day, allow no additional entries and show status of Journal as `COMPLETE`
* Write a method that calculates a weekly average from a users `MoodRating` and returns a score

## Extension IV - Reward Streaks & User Incentive
* Create a database of motiviational quotes
* Write a method that returns a motivational quote to a user on a random basis
	* Send message directly to a users email address
	* extend method to only send motivational quotes to users below a certain MoodRating or below a specific `JournalEntry` average 
* Create a 'Streak' system that rewards users for continued daily usage at certain milestones (i.e. 3 days, 1 week, 1 month) with a virtual ⭐️ point system.
