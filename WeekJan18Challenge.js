//isAdd = true for Additive Persistence, false for Multiplicative Persistence
function getPersistence(input, isAdd) {
    let iterations = 0;
    while (input >= 10) console.log('----iteration ' + ++iterations + ', inputting = ' + input + ', returning ' + (input = String(input).split('').reduce((a, b) => isAdd ? parseInt(a) + parseInt(b) : parseInt(a) * parseInt(b))));
    return iterations;
}


console.log('Additive persistence of 0 = ' + getPersistence(0, true));
console.log('Multiplicative persistence of 0 = ' + getPersistence(0, false));
console.log('Additive persistence of 1 = ' + getPersistence(1, true));
console.log('Multiplicative persistence of 1 = ' + getPersistence(1, false));
console.log('Additive persistence of 123456789 = ' + getPersistence(123456789, true));
console.log('Multiplicative persistence of 123456789 = ' + getPersistence(123456789, false));




//deprecated
// function combineDigits(input, isAdd) {
//     let output = isAdd ? 0 : 1;
//     while (input > 0) {
//         output = isAdd ? output + (input % 10) : output * (input % 10);
//         input = Math.floor(input / 10);
//         console.error('input = ' + input + ', output = ' + output);
//     }
//     return output;
// }

// function combineDigitsStrings(input, isAdd) {
//     output = String(input).split('').reduce((a, b) => isAdd ? parseInt(a) + parseInt(b) : parseInt(a) * parseInt(b));
//     return output;
// }
