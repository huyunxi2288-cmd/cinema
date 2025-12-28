// 获取会员信息
let currentAudienceId = localStorage.getItem("userId") || 'M202512218028';  // 从 localStorage 获取用户 ID

function loadOrders(audienceId, pageNum) {
    const pageSize = 10;  // 每页显示的订单数量
    axios.get(`/order/member/${audienceId}`, {
        params: {
            pageNum: pageNum,
            pageSize: pageSize
        }
    }).then(res => {
        const orders = res.data;  // 假设响应数据为一个订单数组
        const orderList = document.getElementById("order-list");
        orderList.innerHTML = "";  // 清空原有的订单内容

        // 渲染订单数据
        if (orders.length === 0) {
            orderList.innerHTML = "没有订单信息。";
        } else {
            orders.forEach(order => {
                const orderItem = document.createElement("div");
                orderItem.innerHTML = `
                    <div>订单编号: ${order.orderId}</div>
                    <div>订单时间: ${order.orderTime}</div>
                    <div>总金额: ${order.totalAmount}</div>
                    <div>订单状态: ${order.orderStatus}</div>
                    <hr>
                `;
                orderList.appendChild(orderItem);
            });
        }
    }).catch(() => {
        alert("订单加载失败");
    });
}
function logout() {
    // 清除存储的用户信息
    localStorage.removeItem("userId");  // 确保你存储在 localStorage 中的是 userId
    // 跳转到登录页面
    window.location.href = "/member/login.html";
}


// 页面加载时调用
window.onload = function() {
    loadOrders(currentAudienceId, 1); // 加载初始页面
};
