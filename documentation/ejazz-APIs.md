
📘 Ejazz MVP API Specification (by Microservice)
🧑‍🤝‍🧑 account-service
Handles user account management and social connections.
POST   /accounts                  # Create a new user account  
PUT    /accounts/{id}            # Update user account details  
DELETE /accounts/{id}            # Delete user account  
POST   /accounts/{id}/follow     # Follow another user  
POST   /accounts/{id}/unfollow   # Unfollow a user  


📝 post-service
Manages user-generated posts and interactions.
POST   /posts                    # Create a new post  
PUT    /posts/{id}               # Update a post  
DELETE /posts/{id}               # Delete a post  

POST   /posts/{id}/like          # Like a post  
POST   /posts/{id}/dislike       # Dislike a post  
POST   /posts/{id}/share         # Share/repost a post  

POST   /posts/{id}/comments      # Add a comment to a post  
GET    /posts/{id}/comments      # Retrieve comments for a post  


🖼️ media-service
Handles media uploads and retrieval.
POST   /media/upload             # Upload media (image/video)  
GET    /media/{id}               # Retrieve media by ID  
DELETE /media/{id}               # Delete media  


🔔 notification-service
Manages user notifications.
GET    /notifications            # Get current user's notifications  
POST   /notifications            # Create a new notification (internal use)  


📰 feed-service
Generates and serves user feeds.
GET    /feed                     # Get the current user's feed  
GET    /feed/{userId}            # Get a specific user's feed  


