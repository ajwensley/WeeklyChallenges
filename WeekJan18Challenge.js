//isAdd = true for Additive Persistence, false for Multiplicative Persistence
function getPersistence(input, isAdd) {return (input < 10) ? 0 : 1 + getPersistence(String(input).split('').reduce((a, b) => isAdd ? parseInt(a) + parseInt(b) : parseInt(a) * parseInt(b)), isAdd)};


console.log('Additive persistence of 1679583 = ' + getPersistence(1679583, true));
console.log('Additive persistence of 123456 = ' + getPersistence(123456, true));
console.log('Additive persistence of 6 = ' + getPersistence(6, true));

console.log('-----');
console.log('Multiplicative persistence of 77 = ' + getPersistence(77, false));
console.log('Multiplicative persistence of 123456 = ' + getPersistence(123456, false));
console.log('Additive persistence of 4 = ' + getPersistence(4, true));
