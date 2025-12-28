// 1️⃣ 登录校验（会员专属）
const member = JSON.parse(localStorage.getItem("member"));
if (!member) {
    alert("请先登录会员账号");
    location.href = "/member/login.html";
}

// 2️⃣ 加载电影列表
axios.get("/movie/list", {
    params: {
        pageNum: 1,
        pageSize: 20
    }
}).then(res => {
    const movies = res.data;
    const tbody = document.getElementById("movieBody");
    tbody.innerHTML = "";

    movies.forEach(m => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${m.movieId}</td>
            <td>${m.movieName}</td>
            <td>${m.duration} 分钟</td>
            <td>${m.type}</td>
            <td>${m.releaseDate}</td>
            <td>${m.director}</td>
        `;
        tbody.appendChild(tr);
    });
}).catch(() => {
    alert("电影数据加载失败");
});
