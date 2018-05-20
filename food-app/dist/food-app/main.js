(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error('Cannot find module "' + req + '".');
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"]
            ],
            declarations: []
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/http */ "./node_modules/@angular/http/fesm5/http.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _home_home_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./home/home.component */ "./src/app/home/home.component.ts");
/* harmony import */ var _meats_meats_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./meats/meats.component */ "./src/app/meats/meats.component.ts");
/* harmony import */ var _cobbler_cobbler_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./cobbler/cobbler.component */ "./src/app/cobbler/cobbler.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};








var appRoutes = [
    { path: 'home', component: _home_home_component__WEBPACK_IMPORTED_MODULE_5__["HomeComponent"] },
    { path: 'meats', component: _meats_meats_component__WEBPACK_IMPORTED_MODULE_6__["MeatsComponent"] },
    { path: 'cobbler', component: _cobbler_cobbler_component__WEBPACK_IMPORTED_MODULE_7__["CobblerComponent"] },
];
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_4__["NgModule"])({
            declarations: [
                _home_home_component__WEBPACK_IMPORTED_MODULE_5__["HomeComponent"],
                _meats_meats_component__WEBPACK_IMPORTED_MODULE_6__["MeatsComponent"],
                _cobbler_cobbler_component__WEBPACK_IMPORTED_MODULE_7__["CobblerComponent"],
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_3__["AppRoutingModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormsModule"],
                _angular_http__WEBPACK_IMPORTED_MODULE_2__["HttpModule"]
            ],
            providers: [],
            bootstrap: [_home_home_component__WEBPACK_IMPORTED_MODULE_5__["HomeComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/cobbler/cobbler.component.css":
/*!***********************************************!*\
  !*** ./src/app/cobbler/cobbler.component.css ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/cobbler/cobbler.component.html":
/*!************************************************!*\
  !*** ./src/app/cobbler/cobbler.component.html ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n\t\t\t\t<div class=\"row\">\n        \t<div class=\"formatImages\">\n\n            <h1>\n\t\t\t\t\t\t\tWelcome to The Cobbler Section\n            </h1>\n\n            <img class=\"img-fluid\" src=\"./src/assets/images/cobbler1.jpg\" width=\"750\" height=\"500\"><br>\n\t\t\t\t\t\t<h3 class=\"description\">Blackberry Cobbler</h3>\n\t\t\t\t\t\t<p>\n                See there how easy that is. Let's make some happy little clouds in our world. Let's do that again. Don't forget to tell these special people in your life just how special they are to you.\n\t\t\t\t\t\t</p>\n            <img class=\"img-fluid\" src=\"./src/assets/images/cobbler2.jpg\" width=\"750\" height=\"500\"><br>\n\t\t\t\t\t\t<h3 class=\"description\">Cherry Cobbler</h3>\n\t\t\t\t\t\t<p>\n                We spend so much of our life looking - but never seeing. Van Dyke Brown is a very nice brown, it's almost like a chocolate brown. Mix your color marbly don't mix it dead. You can't make a mistake. Anything that happens you can learn to use - and make something beautiful out of it.\n            </p>\n            <img class=\"img-fluid\" src=\"./src/assets/images/cobbler3.jpg\" width=\"750\" height=\"500\"><br>\n\t\t\t\t\t\t<h3 class=\"description\">Strawberry Cobbler</h3>\n\t\t\t\t\t\t<p>\n                Don't fight it, use what happens. We're trying to teach you a technique here and how to use it. We artists are a different breed of people. We're a happy bunch.\n            </p>\n            <img class=\"img-fluid\" src=\"./src/assets/images/cobbler4.jpg\" width=\"750\" height=\"500\"><br>\n\t\t\t\t\t\t<h3 class=\"description\">Cherry Cobbler</h3>\n\t\t\t\t\t\t<p>\n                Look around, look at what we have. Beauty is everywhere, you only have to look to see it. Let's put some happy little clouds in our world. Don't hurry. Take your time and enjoy. Isn't it fantastic that you can change your mind and create all these happy things?\n            </p>\n            <img class=\"img-fluid\" src=\"./src/assets/images/cobbler5.jpg\" width=\"750\" height=\"500\"><br>\n\t\t\t\t\t\t<h3 class=\"description\">Blueberry Peach Cobbler</h3>\n\t\t\t\t\t\t<p>\n                All you have to do is let your imagination go wild. Everyone needs a friend. Friends are the most valuable things in the world. I'll go over the colors one more time that we use: Titanium white, Thalo green, Prussian blue, Van Dyke brown, Alizarin crimson, Sap green, Cad yellow, and Permanent red. Put your feelings into it, your heart, it's your world. You can get away with a lot.\n            </p>\n        </div>\n\t\t\t</div>\n\t\t\t</div>\n"

/***/ }),

/***/ "./src/app/cobbler/cobbler.component.ts":
/*!**********************************************!*\
  !*** ./src/app/cobbler/cobbler.component.ts ***!
  \**********************************************/
/*! exports provided: CobblerComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CobblerComponent", function() { return CobblerComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var CobblerComponent = /** @class */ (function () {
    function CobblerComponent() {
    }
    CobblerComponent.prototype.ngOnInit = function () {
    };
    CobblerComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-cobbler',
            template: __webpack_require__(/*! ./cobbler.component.html */ "./src/app/cobbler/cobbler.component.html"),
            styles: [__webpack_require__(/*! ./cobbler.component.css */ "./src/app/cobbler/cobbler.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], CobblerComponent);
    return CobblerComponent;
}());



/***/ }),

/***/ "./src/app/home/home.component.css":
/*!*****************************************!*\
  !*** ./src/app/home/home.component.css ***!
  \*****************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/home/home.component.html":
/*!******************************************!*\
  !*** ./src/app/home/home.component.html ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n\t\t<div class=\"formatImages\">\n\t\t\t<h1>Welcome to Foodie Central</h1>\n\t\t</div>\n \t\t<form method=\"get\" id=\"typeComment\">\n\t   \t<div class=\"form-group\">\n\t     <label for=\"usr\">Name:</label>\n\t     <input type=\"text\" class=\"form-control\" id=\"usr\">\n\t   \t</div>\n\t\t   <div class=\"form-group\">\n\t\t \t\t<label for=\"description\">Describe your food:</label>\n\t\t \t\t<textarea class=\"form-control\" rows=\"20\" id=\"comment\"></textarea>\n\t\t\t</div>\n\t\t\t<button id=\"submission\" type=\"submit\" class=\"btn btn-secondary\">Submit</button>\n\t\t</form>\n\n\t\t<div class=\"container\">\n\t\t\t<table class=\"allComments\">\n\n\t\t\t</table>\n\t\t\t<!-- <p class=\"name\"></p>\n\t\t\t<p class=\"comment\"></p> -->\n\t\t</div>\n\n\t\t<div class=\"container\">\n\t\t\t<img src=\"./images/food.jpg\" class=\"rounded-circle\" alt=\"Cinque Terre\">\n\t\t</div>\n\n\t\t<div class=\"\">\n\n\t\t</div>\n\n\t<script src=\"foodWeb.js\" type=\"text/javascript\"></script>\n\n\n</div>\n"

/***/ }),

/***/ "./src/app/home/home.component.ts":
/*!****************************************!*\
  !*** ./src/app/home/home.component.ts ***!
  \****************************************/
/*! exports provided: HomeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeComponent", function() { return HomeComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var HomeComponent = /** @class */ (function () {
    function HomeComponent() {
    }
    HomeComponent.prototype.ngOnInit = function () {
    };
    HomeComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-home',
            template: __webpack_require__(/*! ./home.component.html */ "./src/app/home/home.component.html"),
            styles: [__webpack_require__(/*! ./home.component.css */ "./src/app/home/home.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], HomeComponent);
    return HomeComponent;
}());



/***/ }),

/***/ "./src/app/meats/meats.component.css":
/*!*******************************************!*\
  !*** ./src/app/meats/meats.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/meats/meats.component.html":
/*!********************************************!*\
  !*** ./src/app/meats/meats.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n\t\t\t<div class=\"row\">\n\t\t\t\t<div class=\"formatImages\">\n\n\t\t\t\t\t<h1 class=\"description\">\n\t\t\t\t\t\tWelcome to The Meats Section\n\t\t\t\t\t</h1>\n\n\t\t\t\t\t<img class=\"img-fluid\" src=\"http://www.jhbuffalomeat.com/wp-content/uploads/2015/03/buffalo-meat-steak-filet.png\" alt=\"Bison Ny Strip\" width=\"750\" height=\"500\">\n\t\t\t\t\t<h3 class=\"description\">Bison Steak</h3>\n\t\t\t\t\t<p>If you cook it medium rare (or a little less) to medium, the resulting bison steak is a juicy, tender slice of heaven. You want the flavor of the bison meat to shine.</p>\n\n\t\t\t\t\t<img class=\"img-fluid\" src=\"http://www.zestuous.com/wp-content/uploads/2016/05/filet-mignon-1050x700.png\" alt=\"Ny Strip Steak\" width=\"750\" height=\"500\">\n\t\t\t\t\t<h3 class=\"description\">New York Steak</h3>\n\t\t\t\t\t<p>The strip steak is a cut of beef steaks from the short loin from a cow. It consists of a muscle that does little work, the longissimus, making the meat particularly tender; although not as tender as the nearby psoas major or tenderloin.</p>\n\n\t\t\t\t\t<img class=\"img-fluid\" src=\"https://food.fnr.sndimg.com/content/dam/images/food/fullset/2016/1/29/0/KC0811H_Cocoa-Rubbed-New-York-Strip-Steak_s4x3.jpg.rend.hgtvcom.616.462.suffix/1455113922415.jpeg\" alt=\"Filet Steak\" width=\"750\" height=\"500\">\n\t\t\t\t\t<h3 class=\"description\">Filet Steak</h3>\n\t\t\t\t\t<p>Filet mignon (/ˌfiːleɪ ˈmiːnjɒ̃/; French for \"tender fillet\" or \"delicate/fine fillet\") is a steak cut of beef taken from the smaller end of the tenderloin. In French this cut is always called filet de bœuf, which translates in English to beef fillet.</p>\n\n\t\t\t\t\t<img class=\"img-fluid\" src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwIakGRunP3BfSYKEjo5ij97L4so1Gc--84JAHtB3ffb7C-2Hr\" alt=\"Parsely Chicken\" width=\"750\" height=\"500\">\n\t\t\t\t\t<h3 class=\"description\">Parsley chicken</h3>\n\t\t\t\t\t<p>Chicken breasts are the most expensive chicken part to buy, as most people consider the white meat in the breast more desirable than they do the dark meat</p>\n\n\t\t\t\t\t<img class=\"img-fluid\" src=\"https://www.gianteagle.com/PageFiles/11461/article_recipesPlanning_cookingEntertaining_cookingGuides_cookingwithChicken_051012.jpg\" alt=\"Rosemary Chicken\" width=\"750\" height=\"500\">\n\t\t\t\t\t<h3 class=\"description\">Rosemary chicken</h3>\n\t\t\t\t\t<p>Chicken breasts are the most expensive chicken part to buy, as most people consider the white meat in the breast more desirable than they do the dark meat</p>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n"

/***/ }),

/***/ "./src/app/meats/meats.component.ts":
/*!******************************************!*\
  !*** ./src/app/meats/meats.component.ts ***!
  \******************************************/
/*! exports provided: MeatsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MeatsComponent", function() { return MeatsComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var MeatsComponent = /** @class */ (function () {
    function MeatsComponent() {
    }
    MeatsComponent.prototype.ngOnInit = function () {
    };
    MeatsComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-meats',
            template: __webpack_require__(/*! ./meats.component.html */ "./src/app/meats/meats.component.html"),
            styles: [__webpack_require__(/*! ./meats.component.css */ "./src/app/meats/meats.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], MeatsComponent);
    return MeatsComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * In development mode, to ignore zone related error stack frames such as
 * `zone.run`, `zoneDelegate.invokeTask` for easier debugging, you can
 * import the following file, but please comment it out in production mode
 * because it will have performance impact when throw error
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /Users/jjmubang/RevatureCourse/MubangJ/food-app/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map