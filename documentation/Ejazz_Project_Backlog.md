
# Ejazz Project Backlog

## 🧑‍🤝‍🧑 User Service
### 🧩 Feature Title: User Registration & Login
**As a** new user  
**I want to** register and login  
**So that** I can access the platform

### ✅ Acceptance Criteria:
- [ ] User can register with email and password
- [ ] User can login with email and password
- [ ] User receives confirmation email upon registration

### 🔧 Technical Notes:
- Microservice: User Service
- Dependencies: Auth Service, Database
- API Endpoint: `/api/v1/register`, `/api/v1/login`

---

### 🧩 Feature Title: Profile Management
**As a** registered user  
**I want to** manage my profile  
**So that** I can update my personal information

### ✅ Acceptance Criteria:
- [ ] User can update profile picture
- [ ] User can update bio and personal details
- [ ] User can change password

### 🔧 Technical Notes:
- Microservice: User Service
- Dependencies: Database
- API Endpoint: `/api/v1/profile`

---

### 🧩 Feature Title: Follow/Unfollow Users
**As a** registered user  
**I want to** follow or unfollow other users  
**So that** I can see their posts in my feed

### ✅ Acceptance Criteria:
- [ ] User can follow other users
- [ ] User can unfollow other users
- [ ] User sees followed users' posts in feed

### 🔧 Technical Notes:
- Microservice: User Service
- Dependencies: Post Service, Database
- API Endpoint: `/api/v1/follow`, `/api/v1/unfollow`

---

## 📝 Post Service
### 🧩 Feature Title: Create Post
**As a** registered user  
**I want to** create a post  
**So that** I can share content with my followers

### ✅ Acceptance Criteria:
- [ ] User can create text posts
- [ ] User can create image posts
- [ ] Post appears in followers' feeds

### 🔧 Technical Notes:
- Microservice: Post Service
- Dependencies: User Service, Database
- API Endpoint: `/api/v1/posts`

---

### 🧩 Feature Title: Like/Comment on Post
**As a** registered user  
**I want to** like or comment on posts  
**So that** I can engage with content

### ✅ Acceptance Criteria:
- [ ] User can like posts
- [ ] User can comment on posts
- [ ] Likes and comments are visible to others

### 🔧 Technical Notes:
- Microservice: Post Service
- Dependencies: User Service, Database
- API Endpoint: `/api/v1/posts/{post_id}/like`, `/api/v1/posts/{post_id}/comment`

---

### 🧩 Feature Title: Delete/Edit Post
**As a** registered user  
**I want to** delete or edit my posts  
**So that** I can manage my content

### ✅ Acceptance Criteria:
- [ ] User can delete their posts
- [ ] User can edit their posts
- [ ] Changes are reflected in real-time

### 🔧 Technical Notes:
- Microservice: Post Service
- Dependencies: User Service, Database
- API Endpoint: `/api/v1/posts/{post_id}`

---

## 🔔 Notification Service
### 🧩 Feature Title: Push Notifications for Likes/Comments
**As a** registered user  
**I want to** receive notifications for likes and comments  
**So that** I am aware of engagement on my posts

### ✅ Acceptance Criteria:
- [ ] User receives notification for likes
- [ ] User receives notification for comments
- [ ] Notifications are timely and accurate

### 🔧 Technical Notes:
- Microservice: Notification Service
- Dependencies: Post Service, User Service
- API Endpoint: `/api/v1/notifications`

---

### 🧩 Feature Title: Follow Notifications
**As a** registered user  
**I want to** receive notifications when someone follows me  
**So that** I am aware of new followers

### ✅ Acceptance Criteria:
- [ ] User receives notification for new followers
- [ ] Notifications are timely and accurate

### 🔧 Technical Notes:
- Microservice: Notification Service
- Dependencies: User Service
- API Endpoint: `/api/v1/notifications`

---

## 💬 Messaging Service
### 🧩 Feature Title: Direct Messaging
**As a** registered user  
**I want to** send direct messages to other users  
**So that** I can communicate privately

### ✅ Acceptance Criteria:
- [ ] User can send direct messages
- [ ] User can receive direct messages
- [ ] Messages are delivered in real-time

### 🔧 Technical Notes:
- Microservice: Messaging Service
- Dependencies: User Service, Database
- API Endpoint: `/api/v1/messages`

---

### 🧩 Feature Title: Group Chats
**As a** registered user  
**I want to** create and participate in group chats  
**So that** I can communicate with multiple users

### ✅ Acceptance Criteria:
- [ ] User can create group chats
- [ ] User can send messages in group chats
- [ ] Messages are delivered in real-time

### 🔧 Technical Notes:
- Microservice: Messaging Service
- Dependencies: User Service, Database
- API Endpoint: `/api/v1/group-chats`

---

## 🔐 Auth Service
### 🧩 Feature Title: JWT Token Generation
**As a** registered user  
**I want to** have secure authentication  
**So that** I can access protected resources

### ✅ Acceptance Criteria:
- [ ] JWT tokens are generated upon login
- [ ] Tokens are validated for each request
- [ ] Tokens expire after a set period

### 🔧 Technical Notes:
- Microservice: Auth Service
- Dependencies: User Service
- API Endpoint: `/api/v1/auth`

---

### 🧩 Feature Title: OAuth Integration
**As a** new user  
**I want to** register and login using OAuth  
**So that** I can use my existing social accounts

### ✅ Acceptance Criteria:
- [ ] User can register using OAuth providers (e.g., Google, Facebook)
- [ ] User can login using OAuth providers
- [ ] OAuth tokens are validated

### 🔧 Technical Notes:
- Microservice: Auth Service
- Dependencies: User Service
- API Endpoint: `/api/v1/auth/oauth`

---

## 📊 Analytics Service
### 🧩 Feature Title: User Engagement Metrics
**As a** product owner  
**I want to** track user engagement  
**So that** I can analyze platform usage

### ✅ Acceptance Criteria:
- [ ] Metrics for user activity (e.g., posts, likes, comments)
- [ ] Metrics for user retention
- [ ] Metrics are displayed in dashboard

### 🔧 Technical Notes:
- Microservice: Analytics Service
- Dependencies: Post Service, User Service
- API Endpoint: `/api/v1/analytics`

---

### 🧩 Feature Title: Post Reach Tracking
**As a** product owner  
**I want to** track post reach  
**So that** I can analyze content performance

### ✅ Acceptance Criteria:
- [ ] Metrics for post views
- [ ] Metrics for post engagement (e.g., likes, comments)
- [ ] Metrics are displayed in dashboard

### 🔧 Technical Notes:
- Microservice: Analytics Service
- Dependencies: Post Service, User Service
- API Endpoint: `/api/v1/analytics`

---

## 📏 Rules for Managing the Backlog
1. **Use Labels** to categorize issues (e.g., `frontend`, `backend`, `auth`, `priority:high`).
2. **Use Milestones** for releases (e.g., `MVP`, `v1.0`, `v2.0`).
3. **Assign Owners** to each issue.
4. **Review Weekly** to reprioritize and groom the backlog.
5. **Link Issues to Pull Requests** for traceability.
