function trackRobot(input) {
  let output = [0, 0];
  for (let i = 0; i < input.length; i++) {
    output[0] += input[i] * ((((i + 2) % 4) - 2) % 2);
    output[1] += input[i] * ((((i + 3) % 4) - 2) % 2);
  }
  return output;
}
