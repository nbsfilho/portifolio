/* scripts.js */
let currentSlideIndex = 0;

function showSlide(index) {
    const slides = document.querySelectorAll('.carousel-slide');
    const dots = document.querySelectorAll('.dot');
    const totalSlides = slides.length;

    if (index >= totalSlides) {
        currentSlideIndex = 0;
    } else if (index < 0) {
        currentSlideIndex = totalSlides - 1;
    } else {
        currentSlideIndex = index;
    }

    const carouselContainer = document.querySelector('.carousel-container');
    const offset = -currentSlideIndex * 100;
    carouselContainer.style.transform = `translateX(${offset}%)`;

    dots.forEach(dot => dot.classList.remove('active'));
    dots[currentSlideIndex].classList.add('active');
}

function currentSlide(index) {
    showSlide(index);
}

// Initialize the carousel
const dots = document.querySelectorAll('.dot');
dots.forEach((dot, index) => {
    dot.addEventListener('click', () => currentSlide(index));
});

// Optionally, add automatic slide rotation
let autoSlideInterval = setInterval(() => {
    currentSlide((currentSlideIndex + 1) % document.querySelectorAll('.carousel-slide').length);
}, 5000); // Change slide every 5 seconds

// Clear the interval on mouse hover
document.querySelector('.carousel').addEventListener('mouseenter', () => {
    clearInterval(autoSlideInterval);
});
document.querySelector('.carousel').addEventListener('mouseleave', () => {
    autoSlideInterval = setInterval(() => {
        currentSlide((currentSlideIndex + 1) % document.querySelectorAll('.carousel-slide').length);
    }, 5000);
});
