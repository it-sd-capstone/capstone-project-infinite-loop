<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Create Event - Happenings</title>
  <link rel="stylesheet" type="text/css" href="css/styles.css" />
  <link rel="stylesheet" type="text/css" href="css/profile.css" />
  <link rel="stylesheet" type="text/css" href="css/myEvents.css" />
</head>
<body>

<header>
  <h1>Happenings</h1>
  <nav>
    <a href="dashboard.jsp">Home</a>
    <a href="allEvents.jsp">All Events</a>
    <a href="saved.jsp">Saved</a>
    <a href="myEvents.jsp">My Events</a>
    <a href="profile.jsp"><img src="images/profileEmpty.png" class="profile-pic" /></a>
  </nav>
</header>

<main>
  <div class="profile-container">
    <div class="profile-card">
      <h2>Create Event</h2>
      <p class="profile-subtitle">Fill in the details below to post your event.</p>

      <form id="createEventForm" method="POST" action="createEvent" enctype="multipart/form-data">

        <div class="form-group">
          <label for="eventTitle">Event Name</label>
          <input type="text" id="eventTitle" name="title" placeholder="" required />
        </div>

        <div class="form-group">
          <label for="eventCategory">Category</label>
          <select id="eventCategory" name="category" required>
            <option value="" disabled selected>Select a category</option>
            <option value="music">Music</option>
            <option value="sports">Sports</option>
            <option value="food">Food & Drink</option>
            <option value="outdoor">Outdoor</option>
            <option value="technology">Technology</option>
            <option value="community">Community</option>
          </select>
        </div>

        <div class="form-row">
          <div class="form-group">
            <label for="eventDate">Date</label>
            <input type="date" id="eventDate" name="date" required />
          </div>
          <div class="form-group">
            <label for="eventTime">Time</label>
            <input type="time" id="eventTime" name="time" required />
          </div>
        </div>

        <div class="form-group">
          <label for="eventLocation">Location</label>
          <input type="text" id="eventLocation" name="location" placeholder="" required />
        </div>

        <div class="form-group">
          <label for="eventDescription">Description</label>
          <textarea id="eventDescription" name="description" rows="4" placeholder=""></textarea>
        </div>

        <div class="form-group">
          <label for="eventImage">Event Image</label>
          <input type="file" id="eventImage" name="image" accept="image/*" />
        </div>

        <p id="createMessage"></p>

        <div class="form-actions">
          <a href="myEvents.jsp" class="cancel-btn">Cancel</a>
          <button type="submit" class="profile-save-btn">Create Event</button>
        </div>

      </form>
    </div>
  </div>
</main>

</body>
</html>
