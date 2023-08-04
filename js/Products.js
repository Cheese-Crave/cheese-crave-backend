export class Product {
    constructor(image, name, price, description, labels) {
        this.image = image;
        this.name = name;
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
            star.className = "fa-solid fa-star fa-sm";
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
        // Retrieve existing products from local storage
        const existingProducts = JSON.parse(localStorage.getItem('inCart')) || [];

        // Add the new product to the existing products
        existingProducts.push(productToAdd);

        // Store updated products back to local storage
        localStorage.setItem('inCart', JSON.stringify(existingProducts));

        alert('Added to cart!');

    //     // POST request to the server
    //     fetch('http://localhost:3000/api/cart', {
    //         method: 'POST',
    //         headers: {
    //             'Content-Type': 'application/json',
    //         },
    //         body: JSON.stringify(productToAdd),
    //     })
    //         .then((response) => response.json())
    //         .then((data) => {
    //             console.log('Success:', data);
    //             alert('Added to cart!');
    //         })
    //         .catch((error) => {
    //             console.error('Error:', error);
    //         });
    }
}