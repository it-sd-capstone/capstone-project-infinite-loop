<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Saved - Happenings</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css" />
    <link rel="stylesheet" type="text/css" href="css/cards.css" />
    <link rel="stylesheet" type="text/css" href="css/myEvents.css" />
</head>
<body>

<header>
    <h1>Happenings</h1>
    <nav>
        <a href="dashboard.jsp">Home</a>
        <a href="allEvents.jsp">All Events</a>
        <a href="saved.jsp" class="active">Saved</a>
        <a href="myEvents.jsp">My Events</a>
        <a href="profile.jsp"><img src="images/profileEmpty.png" class="profile-pic" /></a>
    </nav>
</header>

<main>
    <div class="page-header">
        <h2>Saved Events</h2>
    </div>

    <div class="myevents-section">
        <div class="allevents-grid" id="savedGrid"></div>
    </div>
</main>

<script>
    // TODO: Replace with database
    const savedEvents = [
        {
            title: 'Bug Eating',
            category: 'food',
            categoryLabel: 'Food & Drink',
            image: 'images/login-bg.jpg',
            description: 'Thousands of free tasty bugs to try.',
            date: 'Sun 4 May - 11:00 AM',
            location: 'The Park'
        }
    ];

    function renderSaved() {
        const grid = document.getElementById('savedGrid');

        savedEvents.forEach(event => {
            const card = document.createElement('div');
            card.className = 'card';
            card.innerHTML =
                '<div class="card-header">' +
                '<a class="event-name">' + event.title + '</a>' +
                '<p class="event-type"><span class="badge ' + event.category + '">' + event.categoryLabel + '</span></p>' +
                '</div>' +
                '<div class="image-container">' +
                '<img src="' + event.image + '" alt="' + event.title + '" onerror="this.style.background=\'#2a2a2a\';this.removeAttribute(\'src\')">' +
                '</div>' +
                '<div class="card-details">' +
                '<p class="desc">' + event.description + '</p>' +
                '<p>&#128197; ' + event.date + '</p>' +
                '<p>&#128205; ' + event.location + '</p>' +
                '</div>';
            grid.appendChild(card);
        });
    }

    document.addEventListener('DOMContentLoaded', renderSaved);
</script>

</body>
</html>