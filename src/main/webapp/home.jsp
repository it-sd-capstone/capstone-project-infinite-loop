<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Home - Happenings</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css" />
    <link rel="stylesheet" type="text/css" href="css/cards.css" />
</head>
<body>

<header>
    <h1>Happenings</h1>
    <nav>
        <a href="login.jsp">Log in</a>
        <a href="register.jsp" class="btn-reg">Register</a>
    </nav>
</header>

<main>
    <div class="home-banner">
        <h2>Discover events near you</h2>
        <p>Your home for finding events that spark your interest, saving your favorites, and creating experiences worth sharing.</p>
    </div>

    <div class="section">
        <div class="section-header">
            <span class="section-title">Recently added</span>
            <%--    TODO make allEvents.jsp only accessible to logged in users and show most recently added--%>
            <a href="allEvents.jsp" class="see-all">See all &rarr;</a>
        </div>
        <div class="cards-grid" id="cardsContainer"></div>
    </div>
</main>

<script>
    const cardsContainer = document.getElementById('cardsContainer');

    // TODO replace with database
    const eventsData = [
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

    function renderCards(data) {
        cardsContainer.innerHTML = '';
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
            cardsContainer.appendChild(card);
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
        renderCards(eventsData);
        enableDragScroll(cardsContainer);
    });
</script>
</body>
</html>