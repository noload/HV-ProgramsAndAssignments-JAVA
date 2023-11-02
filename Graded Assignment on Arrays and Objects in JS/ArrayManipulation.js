// A Retailer would want select customers who have the total Billing amount more than Rs. 3000/-

// Write a program using your JavaScript Skills to print the list of Such Customer Names along with their purchase details.



ShopData=[
    {
        customerID:"CID101",
        customerName:"Neeraj",
        purchasedItem:["notebook","pen"],
        totalBillingAmt:7000
    },{
        customerID:"CID102",
        customerName:"Vaibhav",
        purchasedItem:["laptop","webcam"],
        totalBillingAmt:6000
    },{
        customerID:"CID103",
        customerName:"Keshav",
        purchasedItem:["tshirt","iphone"],
        totalBillingAmt:5000
    },
    {
        customerID:"CID104",
        customerName:"Sohel",
        purchasedItem:["watch","macbook"],
        totalBillingAmt:4000
    },
    {
        customerID:"CID105",
        customerName:"Faisal",
        purchasedItem:["books","pen","pencil"],
        totalBillingAmt:3000
    }
]


let customerWithBill3000=ShopData.filter(function (x) {
    return x.totalBillingAmt > 3000;

    
})
console.log(customerWithBill3000);