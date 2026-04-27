<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Profile - Happenings</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css" />
    <link rel="stylesheet" type="text/css" href="css/profile.css" />
</head>
<body>

<header>
    <h1>Happenings</h1>
    <nav>
        <a href="dashboard.jsp">Home</a>
        <a href="allEvents.jsp">All Events</a>
        <a href="saved.jsp">Saved</a>
        <a href="myEvents.jsp">My Events</a>
        <%-- TODO connect logout  --%>
        <a href="logout">Log out</a>
    </nav>
</header>

<main>
    <div class="profile-container">
        <div class="profile-card">
            <h2>Your Profile</h2>
            <p class="profile-subtitle">Update your interests to find better events.</p>

            <%-- TODO Pre-check categories based on user's saved preferences --%>


            <form id="profileForm" method="POST" action="profile">
                <div class="profile-categories">
                    <p>Select your categories:</p>
                    <label><input type="checkbox" name="categories" value="music"> Music & Art</label>
                    <label><input type="checkbox" name="categories" value="sports"> Sports</label>
                    <label><input type="checkbox" name="categories" value="food"> Food & Drink</label>
                    <label><input type="checkbox" name="categories" value="outdoor"> Outdoor</label>
                    <label><input type="checkbox" name="categories" value="technology"> Technology</label>
                    <label><input type="checkbox" name="categories" value="community"> Community</label>
                </div>
                <button type="submit" class="profile-save-btn">Update</button>
            </form>
        </div>
    </div>
</main>

</body>
</html>