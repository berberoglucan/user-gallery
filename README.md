# USER GALLERY BACKEND

### API METHODS OVERVIEW

| Interface                                                                     |                                              Description                                              | Request Type |
| :---------------------------------------------------------------------------- | :---------------------------------------------------------------------------------------------------: | :----------- |
| /user/allUsers                                                                |                                          Get list of person                                           | GET          |
| /user/allUsersWithPaging?pageNo={pageNo}                                      |                         default pageNo is 1. Error when value is less than 1                          | GET          |
| /user/allUsersWithPaging?pageNo={pageNo}&pageSize={pageSize}                  |                                        default pageSize is 10                                         | GET          |
| /user/allUsersWithPaging?pageNo={pageNo}&pageSize={pageSize}&sortBy=firstName |          default sortBy value is userId. Available sortBy params: name,username, email etc.           | GET          |
| /filter/email/{filterParams}                                                  | Get filtered users by email address with specific filter pattern. Default filter pattern is extension | POST         |
| /filter/email/{filterParams}?pattern=last                                     |                 default pattern is extension. Available patterns : extension and last                 | POST         |
| /album/userAlbums/{userId}                                                    |                                      Get albums of specific user                                      | PUT          |
| /album/userAlbumsWithDetails/{userId}                                         |                                Get albums and photos of specific user                                 | PUT          |
