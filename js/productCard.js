import {Product} from "./Products.js";

const productContainer = document.getElementById('product-container')
let currentPage = 0;
const itemsPerPage = 9;
function displayProducts() {
    fetch('http://localhost:8080/api/product/popular')
        .then((response) => response.json())
        .then((products) => {
            const startIndex = currentPage * itemsPerPage; // start index for the current page
            const endIndex = startIndex + itemsPerPage; // end index for the current page
            productContainer.innerHTML = ""; // Clear existing product cards
            const currentProducts = products.slice(startIndex, endIndex); // Slice products array to get only the items for the current page

            currentProducts.forEach((product) => {
                const labels = [
                    product.milkType,
                    product.type,
                    product.texture,
                    product.flavor,
                    product.aroma,
                    product.vegetarian ? "Vegetarian" : "Non-vegetarian"
                ];

                const productCard = new Product(product.image, product.name, product.price, product.description, labels);
                productContainer.appendChild(productCard.createCard());
            });

            // disables the prev and next buttons based on the current page
            document.getElementById("prev").disabled = (currentPage === 0);
            document.getElementById("next").disabled = (endIndex >= products.length);
        })
        .catch(error => console.error('Error:', error));
}

window.changePage = function(direction) { // window is used to make the function globally available
    currentPage += direction;
    displayProducts(); // Refresh the products with the new page's items
}

displayProducts();