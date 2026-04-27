<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Dashboard - Happenings</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css" />
    <link rel="stylesheet" type="text/css" href="css/cards.css" />
</head>
<body>

<header>
    <h1>Happenings</h1>
    <nav>
        <a href="dashboard.jsp" class="active">Home</a>
        <a href="allEvents.jsp">All Events</a>
        <a href="saved.jsp">Saved</a>
        <a href="myEvents.jsp">My Events</a>
        <a href="profile.jsp"><img src="images/profileEmpty.png" class="profile-pic" /></a>
    </nav>
</header>

<main>
    <div class="home-banner">
        <%-- TODO (backend): Replace "User" with the logged in user --%>
        <h2>Welcome back, User</h2>
        <p>Here's what's happening around you.</p>
    </div>

    <div class="section">
        <div class="section-header">
            <span class="section-title">Saved Events</span>
            <%--    TODO update see all to sort by saved        --%>
            <a href="saved.jsp" class="see-all">See all &rarr;</a>
        </div>
        <div class="cards-grid" id="savedEventsContainer"></div>
    </div>

    <div class="section">
        <div class="section-header">
            <span class="section-title">Recently Added</span>
                <%--    TODO update see all to sort by recent        --%>
            <a href="allEvents.jsp" class="see-all">See all &rarr;</a>
        </div>
        <div class="cards-grid" id="cardsContainer"></div>
    </div>
</main>

<script>
    const cardsContainer = document.getElementById('cardsContainer');
    const savedEventsContainer = document.getElementById('savedEventsContainer');

//TODO replace with database
    const recentEvents = [
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

    //TODO replace with database
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

    const calendarIcon = "&#128197;";
    const locationIcon = "&#128205;";

    function renderCards(data, container) {
        container.innerHTML = '';
        data.forEach(event => {
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
                '<p>' + calendarIcon + ' ' + event.date + '</p>' +
                '<p>' + locationIcon + ' ' + event.location + '</p>' +
                '</div>';
            container.appendChild(card);
        });
    }

    // Enables Scrolling
    function enableDragScroll(grid) {
        let isDown = false, startX, scrollLeft;
        grid.addEventListener('mousedown', e => { isDown = true; grid.style.cursor = 'grabbing'; startX = e.pageX - grid.offsetLeft; scrollLeft = grid.scrollLeft; });
        grid.addEventListener('mouseleave', () => { isDown = false; grid.style.cursor = 'grab'; });
        grid.addEventListener('mouseup', () => { isDown = false; grid.style.cursor = 'grab'; });
        grid.addEventListener('mousemove', e => { if (!isDown) return; e.preventDefault(); grid.scrollLeft = scrollLeft - (e.pageX - grid.offsetLeft - startX); });
        grid.style.cursor = 'grab';
    }

    document.addEventListener('DOMContentLoaded', () => {
        renderCards(savedEvents, savedEventsContainer);
        renderCards(recentEvents, cardsContainer);
        enableDragScroll(savedEventsContainer);
        enableDragScroll(cardsContainer);
    });
</script>
</body>
</html>