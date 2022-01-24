function isDisarium(input) {return (input == String(input).split('').map((a, index) => parseInt(a)**(index + 1)).reduce((a, b) => a + b));}
