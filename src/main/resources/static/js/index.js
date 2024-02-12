$(document).ready(function () {
// 섹션2 슬라이드 정의
        var swiper = new Swiper(".meeting_container", {
            // slidesPerView: 3,
            spaceBetween: 50,
            loop: true,
            navigation: {
                prevEl: ".swiper-button-prev",
                nextEl: ".swiper-button-next",
            },
            breakpoints: {
                200: {
                    slidesPerView: 1,
                },
                900: {
                    slidesPerView: 2,
                    spaceBetween: 50,
                },
                1300: {
                    slidesPerView: 3,
                    spaceBetween: 70,
                }
            }
        });

// 섹션3 슬라이드 정의
        var swiper2 = new Swiper(".recommendation_container", {
            spaceBetween: 100,
            effect: "cards",
            grabCursor: true,
        });
});
