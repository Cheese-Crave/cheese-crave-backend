import { Product } from "./Product.js"


window.addEventListener('storage', displayCart); // cart is updated when local storage is updated

const productContainer = document.getElementById('product-container');
const products = JSON.parse(localStorage.getItem('products')) || []; // loading product from local storage

if (products.length === 0) {
    const noProducts = document.createElement('p');
    noProducts.textContent = 'No Products Found';
    productContainer.appendChild(noProducts);
} else {
    products.forEach((productData) => {
        const {image, name, price, description, labels} = productData; // extracting properties from local storage array
        const product = new Product(image, name, price, description, labels); // create new instance of Product class
        const productCard = product.createCard(); // create product cards for each product
        productContainer.appendChild(productCard); // adding to product.html
    });
}
