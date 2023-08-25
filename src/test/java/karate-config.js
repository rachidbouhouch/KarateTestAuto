function fn() {
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev';
  }
  var randomEmail = function() {
    var chars = "abcdefghijklmnopqrstuvwxyz1234567890";
    var email = "";
    for (var i = 0; i < 10; i++) {
      var randomIndex = Math.floor(Math.random() * chars.length);
      email += chars.charAt(randomIndex);
    }
    return email + "@example.com";
  };
  var randomName = function() {
    var firstNames = ["Alice", "Bob", "Charlie", "David", "Eve", "Frank"];
    var lastNames = ["Smith", "Johnson", "Williams", "Jones", "Brown", "Davis"];

    var randomFirstNameIndex = Math.floor(Math.random() * firstNames.length);
    var randomLastNameIndex = Math.floor(Math.random() * lastNames.length);

    return firstNames[randomFirstNameIndex] + " " + lastNames[randomLastNameIndex];
  };

  var config = {
    env: env,
    myVarName: 'someValue',
    baseURL:'https://simple-books-api.glitch.me/',
    clientName: randomName(),
    clientEmail: randomEmail()
  }

  if (env == 'dev') {
    // customize
    // e.g. config.foo = 'bar';
  } else if (env == 'e2e') {
    // customize
  }
  return config;
}