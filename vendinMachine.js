function vendingMachine(productsList, money, productNum) {
  
  let productName = '';
  if (productNum < productsList.length) {
    productName = productsList[productNum].get('Name');
    money -= productsList[productNum].get('Cost');
  } else {
    return "Enter a valid product number";
  }
  
  if (money < 0) {
    return "Not enough money for this product";
  }

  let coins = [500, 200, 100, 50, 20, 10];
  let change = [];
  
  coins.forEach(function(coin) {
    while (money >= coin) {
       money -= coin;
       change.push(coin);
    }
  });
  
  let output = new Map();
  output.set("Product", productName);
  output.set("Change", change);
  return output;
}



let products = [];
for (let i = 0; i < 10; i++) {
  let product = new Map();
  product.set('Name', 'Product ' + i);
  product.set('Cost', i * 100);
  products.push(product);
}

vendingMachine(products, 200, 1); //Product 1, [100]
vendingMachine(products, 200, 3); //"Not enough money for this product"
vendingMachine(products, 200, 11); //"Enter a valid product number"
vendingMachine(products, 199, 1); //Product 1, [50, 20, 20];
