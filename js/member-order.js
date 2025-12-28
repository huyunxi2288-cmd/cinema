function loadOrders(audienceId, pageNum) {
    const pageSize = 10;  // 每页显示的订单数量
    console.log("当前会员ID：", audienceId); // 调试：检查 audienceId 是否正确传递
    axios.get(`/order/member/${audienceId}`, {
        params: {
            pageNum: pageNum,
            pageSize: pageSize
        }
    }).then(res => {
        const orders = res.data;
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

        // 分页功能
        const pagination = document.getElementById("pagination");
        pagination.innerHTML = `
            <button onclick="loadOrders('${audienceId}', ${pageNum - 1})" ${pageNum === 1 ? 'disabled' : ''}>上一页</button>
            <span>第 ${pageNum} 页</span>
            <button onclick="loadOrders('${audienceId}', ${pageNum + 1})">下一页</button>
        `;
    }).catch((err) => {
        console.error("订单加载失败:", err);
        alert("订单加载失败，请稍后再试。");
    });
}

// 从 localStorage 或 sessionStorage 获取当前用户的 audienceId
let currentAudienceId = localStorage.getItem("audienceId") || 'M202512218028';  // 获取会员 ID
let currentPage = 1;

// 页面加载时调用
window.onload = function() {
    loadOrders(currentAudienceId, currentPage);
};
