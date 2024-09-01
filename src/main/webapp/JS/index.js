document.querySelectorAll('input[name = "rightChoiceButton"]').forEach((radio) => {
    radio.addEventListener('change', function () {
        if (this.value == "web") {
            document.getElementById("gamePage").style.display = 'none';
            document.getElementById("webPage").style.display = 'block';
        } else if (this.value == "game") {
            document.getElementById("gamePage").style.display = 'block';
            document.getElementById("webPage").style.display = 'none';
        }
    });
});

// 仿链接访问后样式代码
//--------------------------------------------------------------------------------------------------------------------
document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('.link').forEach(function (link) {
        if (linkVisited(link)) {
            link.classList.add('visited');
        }
    });
});

function linkVisited(url) {
    var visited = localStorage.getItem('visited_links');
    if (!visited) {
        visited = [];
    } else {
        visited = JSON.parse(visited);
    }
    return visited.includes(url);
}

document.addEventListener('click', function (event) {
    var target = event.target;
    if (target.classList.contains('link')) {
        target.classList.add('visited');
        var visited = localStorage.getItem('visited_links');
        if (!visited) {
            visited = [];
        } else {
            visited = JSON.parse(visited);
        }
        visited.push(target.href);
        localStorage.setItem('visited_links', JSON.stringify(visited));
    }
});

//音乐播放控制
//--------------------------------------------------------------------------------------------------------------------
window.onload = function () {
    var audio = document.getElementById('BGmusic');

    document.addEventListener('visibilitychange', function () {
        if (document.visibilityState === "hidden") {
            audio.src = '';
        } else {
            audio.src = '../资源/重复时.mp3';
        }
    });
};

//Detail页面控制
//--------------------------------------------------------------------------------------------------------------------
document.addEventListener('DOMContentLoaded', function() {
    document.querySelectorAll('div.leftChoiceButton').forEach((button) => {
        button.addEventListener('mouseover', function() {
            var input = this.previousElementSibling;  // 获取前一个兄弟元素，即 input 元素
            var targetId = input.value;  // 获取 input 元素的 value
            document.querySelectorAll('.ContentPage').forEach((page) => {
                if (page.id === targetId) {
                    page.style.display = 'block';
                } else {
                    page.style.display = 'none';
                }
            });
        });
    });
});




