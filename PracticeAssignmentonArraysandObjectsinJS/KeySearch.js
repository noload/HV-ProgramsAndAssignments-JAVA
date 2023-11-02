// Object Key Search
// "John Doe": "123-456-7890", "Emma Smith": "987-654-3210" }, Name: "Emma Smith"
Contact_list=[
    {
        Name:"John Doe",
        ph_no:"123-456-7890"
    },
    {
        Name:"Emma Smith",
        ph_no:"987-654-3210"
    }
]
Key="Emma Smith"
for(let i=0;i<Contact_list.length;i++){
    if (Contact_list[i].Name==Key) {
        console.log("Phone Number of ",Key," is ",Contact_list[i].ph_no)
    }
}