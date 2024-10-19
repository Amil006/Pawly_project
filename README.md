<img width="100%" src="https://capsule-render.vercel.app/api?type=waving&color=000000&height=120&section=header"/>

<h3 align="center">Welcome to Pawly 🐾</h3>

<p align="center">
    Pawly is a dynamic pet adoption and care management platform designed to streamline the process of adopting, surrendering, and caring for animals. The application connects users with shelters, veterinarians, and other pet-related services, aiming to improve the quality of life for pets and their owners.
</p>

<hr/>

<h2>About</h2>
<p>Pawly is a startup project that originated from a need for a user-friendly system to support animal welfare. The project was initially designed using Figma to ensure a seamless and intuitive user experience. It integrates a full-stack approach with a Spring Boot backend and a dynamic, responsive frontend.</p>

<h2>Features</h2>
<ul>
    <li><strong>Pet Adoption & Surrender:</strong> Users can browse pets available for adoption or surrender their own pets, with filtering options based on species, breed, and location.</li>
    <li><strong>User Authentication:</strong> Secure login and registration with JWT-based authentication to manage user sessions.</li>
    <li><strong>Veterinarian Services:</strong> A database of veterinarians with their services, contact information, and user reviews.</li>
    <li><strong>Favorite Lists:</strong> Users can save their favorite pets and shelters for easy access later.</li>
    <li><strong>Dynamic Frontend:</strong> The frontend dynamically integrates data from the backend using AJAX and API calls.</li>
    <li><strong>Mobile-Friendly:</strong> The project is designed to be responsive and optimized for both desktop and mobile devices.</li>
</ul>

<h2>Technologies Used</h2>
<h3>Backend</h3>
<ul>
    <li><strong>Java & Spring Boot:</strong> The backend is built using Spring Boot, enabling RESTful API services and secure user authentication.</li>
    <li><strong>JWT Authentication:</strong> JSON Web Tokens are used to secure communication between the client and the server.</li>
    <li><strong>Jackson for JSON:</strong> Handles JSON parsing and serialization.</li>
    <li><strong>File-based Storage:</strong> The project initially uses stream-based file storage for user and pet data.</li>
</ul>

<h3>Frontend</h3>
<ul>
    <li><strong>HTML5, CSS3, JavaScript:</strong> Core technologies for building the structure and style of the application.</li>
    <li><strong>AJAX & Fetch API:</strong> For handling dynamic data fetching and updating the UI in real-time.</li>
    <li><strong>Responsive Design:</strong> CSS media queries ensure the site adapts to different screen sizes.</li>
    <li><strong>Figma Prototyping:</strong> The project was designed in Figma to ensure a smooth, user-centered interface before development began.</li>
</ul>

<h2>Installation & Setup</h2>
<ol>
    <li>Clone the repository:
        <pre><code>git clone https://github.com/yourusername/pawly.git</code></pre>
    </li>
    <li>Navigate to the project directory and install the necessary backend dependencies:
        <pre><code>cd pawly/backend<br />./mvnw install</code></pre>
    </li>
    <li>Run the Spring Boot backend:
        <pre><code>./mvnw spring-boot:run</code></pre>
    </li>
    <li>Serve the frontend by opening index.html in your browser or using a local server (e.g., Live Server in VS Code).</li>
</ol>

<h2>API Documentation</h2>

<h3>User Authentication</h3>

<h4>Login User</h4>
<ul>
    <li><strong>Endpoint:</strong> POST /api/auth/login</li>
    <li><strong>Request Body:</strong>
        <pre><code>{
    "username": "yourUsername",
    "password": "yourPassword"
}</code></pre>
    </li>
    <li><strong>Response:</strong>
        <pre><code>{
    "token": "yourAccessToken",
    "user": {
        "id": 1,
        "username": "yourUsername",
        "role": "USER"
    }
}</code></pre>
    </li>
</ul>

<h4>Register User</h4>
<ul>
    <li><strong>Endpoint:</strong> POST /api/auth/register</li>
    <li><strong>Request Body:</strong>
        <pre><code>{
    "username": "newUsername",
    "password": "newPassword",
    "email": "email@example.com"
}</code></pre>
    </li>
    <li><strong>Response:</strong>
        <pre><code>{
    "message": "User registered successfully"
}</code></pre>
    </li>
</ul>

<h3>Pet Management</h3>

<h4>Get All Pets</h4>
<ul>
    <li><strong>Endpoint:</strong> GET /api/pets</li>
    <li><strong>Response:</strong>
        <pre><code>[
    {
        "id": 1,
        "name": "Buddy",
        "species": "Dog",
        "breed": "Golden Retriever",
        "age": 4,
        "adoptionStatus": "Available"
    },
    {
        "id": 2,
        "name": "Whiskers",
        "species": "Cat",
        "breed": "Siamese",
        "age": 2,
        "adoptionStatus": "Adopted"
    }
]</code></pre>
    </li>
</ul>

<h4>Add New Pet</h4>
<ul>
    <li><strong>Endpoint:</strong> POST /api/pets</li>
    <li><strong>Request Body:</strong>
        <pre><code>{
    "name": "Fluffy",
    "species": "Rabbit",
    "breed": "Holland Lop",
    "age": 1,
    "adoptionStatus": "Available"
}</code></pre>
    </li>
    <li><strong>Response:</strong>
        <pre><code>{
    "message": "Pet added successfully"
}</code></pre>
    </li>
</ul>

<h3>Veterinarian Services</h3>

<h4>Get All Veterinarians</h4>
<ul>
    <li><strong>Endpoint:</strong> GET /api/veterinarians</li>
    <li><strong>Response:</strong>
        <pre><code>[
    {
        "id": 1,
        "name": "Dr. Jane Doe",
        "specialty": "General",
        "location": "123 Main St",
        "phone": "555-1234"
    },
    {
        "id": 2,
        "name": "Dr. John Smith",
        "specialty": "Surgery",
        "location": "456 Elm St",
        "phone": "555-5678"
    }
]</code></pre>
    </li>
</ul>

<h4>Add New Veterinarian</h4>
<ul>
    <li><strong>Endpoint:</strong> POST /api/veterinarians</li>
    <li><strong>Request Body:</strong>
        <pre><code>{
    "name": "Dr. Alex Johnson",
    "specialty": "Dentistry",
    "location": "789 Oak St",
    "phone": "555-9876"
}</code></pre>
    </li>
    <li><strong>Response:</strong>
        <pre><code>{
    "message": "Veterinarian added successfully"
}</code></pre>
    </li>
</ul>

<!-- ... -->

<h2>Future Plans</h2>
<p>We are constantly working to improve Pawly. Some upcoming features include:</p>
<ul>
    <li>Enhanced user profiles with more pet management options.</li>
    <li>Integration of a chat feature for users to connect with shelters directly.</li>
    <li>Mobile app version for easier access on the go.</li>
</ul>

<h2>License</h2>
<p>This project is licensed under the MIT License - see the <a href="LICENSE">LICENSE</a> file for details.</p>

<!-- ... -->

<img width="100%" src="https://capsule-render.vercel.app/api?type=waving&color=000000&height=120&section=footer"/>
