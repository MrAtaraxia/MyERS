var message = "hello";
console.log(message);
var Greeting = /** @class */ (function () {
    function Greeting(name) {
        this.name = name;
    }
    Greeting.prototype.greet = function () {
        console.log("Hello" + this.name);
        return "Hello, " + this.name;
    };
    return Greeting;
}());
var greeter = new Greeting("Bob");
greeter.greet;
