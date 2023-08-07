import {databaseURL} from "./config.js";
export class Product {
    constructor(productId, image, name, averageRating, price, description, labels) {
        this.productId = productId;
        this.image = image;
        this.name = name;
        this.averageRating = averageRating;
        this.price = price;
        this.description = description;
        this.labels = labels;
    }

    createCard() {
        // empty container used for styling
        const section = document.createElement("section");
        section.className = 'card';

        // product image
        const productImage = document.createElement("img");
        productImage.src = this.image;
        section.appendChild(productImage);

        // product name & ratings
        const productHeading = document.createElement("div");
        productHeading.className = "productHead";

        const productName = document.createElement("h3");
        productName.textContent = this.name;
        productHeading.appendChild(productName);
        section.appendChild(productHeading);

        let star;
        for (let i = 1; i <= 5; i++) {
            star = document.createElement("i");
            star.className = i <= this.averageRating ? "fa-solid fa-star fa-sm filled" : "fa-solid fa-star fa-sm";
            star.addEventListener('click', () => rateProduct(i));
            productHeading.appendChild(star);
        }
        section.appendChild(productHeading);

        // product price
        const productPrice = document.createElement("p");
        productPrice.textContent = `$${this.price}.00`;
        section.appendChild(productPrice);

        // product description
        const productDescription = document.createElement("details");
        const productSummary = document.createElement("summary");
        const productDescriptionText = document.createElement("p");
        productSummary.textContent = `Read about ${this.name}`;
        productDescriptionText.textContent = this.description;

        productDescription.appendChild(productSummary);
        productDescription.appendChild(productDescriptionText);
        section.appendChild(productDescription);

        // product characteristics via labels
        const labelsContainer = document.createElement("section");
        labelsContainer.className = "label";
        this.labels.forEach((label) => {
            const labelElement = document.createElement("p");
            labelElement.className = "characteristics";
            labelElement.innerHTML = label;
            labelsContainer.appendChild(labelElement);
        });
        section.appendChild(labelsContainer);

        // cart & wishlist buttons container
        const productIconContainer = document.createElement("aside");
        // add to cart button
        const addToCart = document.createElement('i');
        addToCart.className = "fa-solid fa-cart-shopping fa-2xl";
        // when clicked, the addToCart method is called
        addToCart.addEventListener('click', () => {
            this.addToCart();
        });
        productIconContainer.appendChild(addToCart);

        // add to wishlist button
        const addToWishlist = document.createElement('i');
        addToWishlist.className = "fa-solid fa-gift fa-2xl";
        productIconContainer.appendChild(addToWishlist);

        section.appendChild(productIconContainer);

        return section;
    }
    addToCart() {
        const productToAdd = {
            image: this.image,
            name: this.name,
            price: this.price,
            quantity: 1,
        };

        const existingProducts = JSON.parse(localStorage.getItem('inCart')) || []; // Retrieve existing products from local storage
        existingProducts.push(productToAdd); // Add the new product to the existing products
        localStorage.setItem('inCart', JSON.stringify(existingProducts)); // Store updated products back to local storage
        alert('Added to cart!');
    }

    rateProduct(rating) {

        const ratingData = {
            productId: this.productId,
            rating: rating
        };

        // Send the rating to the server
        fetch(`${databaseURL}/api/product/${this.productId}/rating`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(ratingData),
        })
            .then((response) => response.json())
            .then((data) => {
                this.averageRating = data.averageRating; // Update the display with the new average rating
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }
}