<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>All Events - Happenings</title>
  <link rel="stylesheet" type="text/css" href="css/styles.css" />
  <link rel="stylesheet" type="text/css" href="css/cards.css"/>
</head>
<body>

<header>
  <h1>Happenings</h1>
  <nav>
    <a href="dashboard.jsp">Home</a>
    <a href="allEvents.jsp" class="active">All Events</a>
    <a href="saved.jsp">Saved</a>
    <a href="myEvents.jsp">My Events</a>
    <a href="profile.jsp"><img src="images/profileEmpty.png" class="profile-pic" /></a>
  </nav>
</header>

<main>
  <div class="events-toolbar">
    <div class="search-bar">
      <span>&#128269;</span>
      <input type="text" id="eventSearch" placeholder="Search for events..." oninput="handleSearch()">
    </div>
    <div class="sort-dropdown">
      <button class="sort-btn" onclick="toggleSortMenu()">
        <span id="sortLabel">Default sorting</span>
        <span>&#8964;</span>
      </button>
      <div class="sort-menu" id="sortMenu">
        <div class="sort-option" onclick="setSort('default')">Default</div>
        <div class="sort-option" onclick="setSort('recent')">Recent</div>
        <div class="sort-option" onclick="setSort('oldest')">Oldest</div>
      </div>
    </div>
  </div>

  <div class="category-filters">
    <button class="cat-filter active" onclick="setCategory('all', this)">All</button>
    <button class="cat-filter music" onclick="setCategory('music', this)">Music & Art</button>
    <button class="cat-filter sports" onclick="setCategory('sports', this)">Sports</button>
    <button class="cat-filter food" onclick="setCategory('food', this)">Food & Drink</button>
    <button class="cat-filter outdoor" onclick="setCategory('outdoor', this)">Outdoor</button>
    <button class="cat-filter technology" onclick="setCategory('technology', this)">Technology</button>
    <button class="cat-filter community" onclick="setCategory('community', this)">Community</button>
  </div>

  <div class="allevents-grid" id="eventsGrid"></div>

  <div class="pagination-bar">
    <div class="pagination" id="pagination"></div>
  </div>
</main>

<%-- Shows 36 cards per page--%>
<script>
  const CARDS_PER_PAGE = 36;
  let currentPage = 1;
  let currentCategory = 'all';
  let currentSort = 'default';

  // TODO: Replace with database
  const allEvents = [
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

  function setCategory(cat, el) {
    currentCategory = cat;
    currentPage = 1;
    document.querySelectorAll('.cat-filter').forEach(b => b.classList.remove('active'));
    el.classList.add('active');
    filterEvents();
  }

  function setSort(sort) {
    currentSort = sort;
    currentPage = 1;
    const labels = { default: 'Default sorting', recent: 'Recent', oldest: 'Oldest' };
    document.getElementById('sortLabel').textContent = labels[sort];
    document.getElementById('sortMenu').classList.remove('open');
    filterEvents();
  }

  function toggleSortMenu() {
    document.getElementById('sortMenu').classList.toggle('open');
  }

  function handleSearch() {
    currentPage = 1;
    filterEvents();
  }

  function filterEvents() {
    const query = document.getElementById('eventSearch').value.toLowerCase();

    let filtered = allEvents.filter(e => {
      const matchesCategory = currentCategory === 'all' || e.category === currentCategory;
      const matchesSearch = e.title.toLowerCase().includes(query) || e.categoryLabel.toLowerCase().includes(query);
      return matchesCategory && matchesSearch;
    });

    if (currentSort === 'recent') filtered.sort((a, b) => b.timestamp - a.timestamp);
    if (currentSort === 'oldest') filtered.sort((a, b) => a.timestamp - b.timestamp);

    renderEvents(filtered);
  }

  function renderEvents(events) {
    const grid = document.getElementById('eventsGrid');
    const pagination = document.getElementById('pagination');
    const totalPages = Math.ceil(events.length / CARDS_PER_PAGE);
    const start = (currentPage - 1) * CARDS_PER_PAGE;
    const pageEvents = events.slice(start, start + CARDS_PER_PAGE);

    grid.innerHTML = '';
    pageEvents.forEach(event => {
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

    pagination.innerHTML = '';
    for (let i = 1; i <= totalPages; i++) {
      const btn = document.createElement('button');
      btn.textContent = i;
      btn.className = 'page-btn' + (i === currentPage ? ' active' : '');
      btn.onclick = () => {
        currentPage = i;
        filterEvents();
        window.scrollTo({ top: 0, behavior: 'smooth' });
      };
      pagination.appendChild(btn);
    }
  }

  document.addEventListener('click', e => {
    if (!e.target.closest('.sort-dropdown')) {
      document.getElementById('sortMenu').classList.remove('open');
    }
  });

  document.addEventListener('DOMContentLoaded', () => filterEvents());
</script>

</body>
</html>