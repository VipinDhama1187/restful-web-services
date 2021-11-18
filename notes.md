#  Restful Web Services

Social Media Application

User --> Posts (a user can create multiple posts.. So it is a one to many relationship from user to posts and a post cannot exists without user)

- Retrieve all user 					GET /users
- Create a user						POST /users
- Retrieve one user 				GET /users/{id} -->  /users/1
- Delete one user					DELETE /users/{id}--> /users/1


- Retrieve all posts for a user 			GET /users/{id}/posts
- Create a post for a user 					POST /users/{id}/posts
- Retrieve details of a post				GET /users/{id}/posts/{post_id}

