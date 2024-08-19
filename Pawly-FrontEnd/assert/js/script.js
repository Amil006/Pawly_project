// const span=document.querySelectorAll(".heart-icon")
// span.forEach(spanEl=>spanEl.addEventListener("click",()=>{
// console.log("dfr");
// const i=document.querySelectorAll(".fa-heart")
// i.forEach(icon=>{
//     icon.style.color="#C06734"
//     icon.style.fontWeight="600"
// })

// }))


const spans = document.querySelectorAll(".heart-icon");

spans.forEach((spanEl) => {
    spanEl.addEventListener("click", () => {
        const icon = spanEl.querySelector("i");

       
        if (icon.style.color === "#C06734") {
            icon.style.color = "";
            icon.style.fontWeight = "";
        } else {
           
            spans.forEach(s => {
                s.querySelector("i").style.color = "";
                s.querySelector("i").style.fontWeight = "";
            });
          
            icon.style.color = "#C06734";
            icon.style.fontWeight = "600";
        }
    });
});

