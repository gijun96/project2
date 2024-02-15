$(document).ready(function () {
        // 햄버거 메뉴 활성화, 비활성화
        $(".hamburger").on("click", function () {
            if ($(".hamburger_menu").css("display") == "none") {
                $(".hamburger_menu").css({ "display": "block" });
            } else {
                $(".hamburger_menu").css({ "display": "none" });
            }
        });

        // 일정 창크기 이상시 햄버거 메뉴 안보이기
        $(window).on("resize", function () {
            if(window.innerWidth > 900) {
                $(".hamburger_menu").css({ "display": "none" });
            }
        });
       });