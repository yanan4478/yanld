webpackJsonp([0,2],{

/***/ 106:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(109)();
	// imports


	// module
	exports.push([module.id, ".list {\n  padding-left: 5px;\n}\n", ""]);

	// exports


/***/ },

/***/ 107:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(109)();
	// imports


	// module
	exports.push([module.id, ".listItem {\n  border-bottom: 1px dotted #D9D9D9;\n  padding: 15px 0px;\n}\n.listItem .gutter {\n  padding: 5px 0px;\n}\n.listItem .title {\n  color: #555555;\n  font-weight: bold;\n  font-size: 18px;\n  font-family: \"lucida grande\", \"lucida sans unicode\", lucida, helvetica, \"Hiragino Sans GB\", \"Microsoft YaHei\", \"WenQuanYi Micro Hei\", sans-serif;\n}\n.listItem .title a {\n  color: #555555;\n}\n.listItem .title a:active {\n  color: #000;\n}\n.listItem .author {\n  color: #2DB7F5;\n}\n.listItem .createDate {\n  color: #717171;\n}\n.listItem .foot a {\n  color: #999999;\n  display: inline-block;\n  margin-right: 10px;\n}\n", ""]);

	// exports


/***/ },

/***/ 108:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(109)();
	// imports


	// module
	exports.push([module.id, ".tab {\n  color: #000;\n  padding: 5px 15px;\n  border-radius: 14px;\n  border: 1px solid #D9D9D9;\n  font-size: 11px;\n  line-height: 18px;\n  float: left;\n  margin-right: 15px;\n}\n.tab:active {\n  color: #fff;\n  background-color: #2DB7F5;\n}\n.tab:hover {\n  color: #fff;\n  background-color: #2DB7F5;\n}\n", ""]);

	// exports


/***/ },

/***/ 345:
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(106);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(139)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(106, function() {
				var newContent = __webpack_require__(106);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 346:
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(107);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(139)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(107, function() {
				var newContent = __webpack_require__(107);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 347:
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(108);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(139)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(108, function() {
				var newContent = __webpack_require__(108);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 363:
/***/ function(module, exports, __webpack_require__) {

	module.exports = __webpack_require__.p + "img/969c7c1a.contentCover.jpg"

/***/ },

/***/ 403:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(8), RootInstanceProvider = __webpack_require__(6), ReactMount = __webpack_require__(3), React = __webpack_require__(1); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	/**
	 * Created by XK on 2016/6/28.
	 */
	'use strict';

	Object.defineProperty(exports, '__esModule', {
	    value: true
	});

	var _createClass = (function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ('value' in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; })();

	var _get = function get(_x, _x2, _x3) { var _again = true; _function: while (_again) { var object = _x, property = _x2, receiver = _x3; desc = parent = getter = undefined; _again = false; if (object === null) object = Function.prototype; var desc = Object.getOwnPropertyDescriptor(object, property); if (desc === undefined) { var parent = Object.getPrototypeOf(object); if (parent === null) { return undefined; } else { _x = parent; _x2 = property; _x3 = receiver; _again = true; continue _function; } } else if ('value' in desc) { return desc.value; } else { var getter = desc.get; if (getter === undefined) { return undefined; } return getter.call(receiver); } } };

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { 'default': obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError('Cannot call a class as a function'); } }

	function _inherits(subClass, superClass) { if (typeof superClass !== 'function' && superClass !== null) { throw new TypeError('Super expression must either be null or a function, not ' + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	var _react = __webpack_require__(1);

	var _react2 = _interopRequireDefault(_react);

	var _reactRedux = __webpack_require__(17);

	var _reduxRouter = __webpack_require__(19);

	__webpack_require__(345);

	var List = (function (_React$Component) {
	    _inherits(List, _React$Component);

	    function List() {
	        var _this = this;

	        _classCallCheck(this, List);

	        _get(Object.getPrototypeOf(List.prototype), 'constructor', this).apply(this, arguments);

	        this.render = function () {
	            return _react2['default'].createElement(
	                'div',
	                null,
	                _react2['default'].createElement(
	                    'ul',
	                    { className: 'list' },
	                    _this.props.children
	                )
	            );
	        };
	    }

	    _createClass(List, null, [{
	        key: 'defaultProps',
	        value: {},
	        enumerable: true
	    }]);

	    return List;
	})(_react2['default'].Component);

	exports['default'] = List;
	module.exports = exports['default'];

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(7); if (makeExportsHot(module, __webpack_require__(1))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "List.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(9)(module)))

/***/ },

/***/ 404:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(8), RootInstanceProvider = __webpack_require__(6), ReactMount = __webpack_require__(3), React = __webpack_require__(1); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	/**
	 * Created by XK on 2016/6/28.
	 */
	'use strict';

	Object.defineProperty(exports, '__esModule', {
	    value: true
	});

	var _createClass = (function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ('value' in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; })();

	var _get = function get(_x, _x2, _x3) { var _again = true; _function: while (_again) { var object = _x, property = _x2, receiver = _x3; desc = parent = getter = undefined; _again = false; if (object === null) object = Function.prototype; var desc = Object.getOwnPropertyDescriptor(object, property); if (desc === undefined) { var parent = Object.getPrototypeOf(object); if (parent === null) { return undefined; } else { _x = parent; _x2 = property; _x3 = receiver; _again = true; continue _function; } } else if ('value' in desc) { return desc.value; } else { var getter = desc.get; if (getter === undefined) { return undefined; } return getter.call(receiver); } } };

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { 'default': obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError('Cannot call a class as a function'); } }

	function _inherits(subClass, superClass) { if (typeof superClass !== 'function' && superClass !== null) { throw new TypeError('Super expression must either be null or a function, not ' + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	var _react = __webpack_require__(1);

	var _react2 = _interopRequireDefault(_react);

	var _reactRedux = __webpack_require__(17);

	var _reduxRouter = __webpack_require__(19);

	var _antd = __webpack_require__(51);

	__webpack_require__(346);

	var ListItem = (function (_React$Component) {
	    _inherits(ListItem, _React$Component);

	    function ListItem() {
	        var _this = this;

	        _classCallCheck(this, ListItem);

	        _get(Object.getPrototypeOf(ListItem.prototype), 'constructor', this).apply(this, arguments);

	        this.render = function () {
	            console.log("++++++++++++++++++");
	            console.log(_this.props.content);
	            return _react2['default'].createElement(
	                'li',
	                { className: 'listItem' },
	                _react2['default'].createElement(
	                    _antd.Row,
	                    null,
	                    _react2['default'].createElement(
	                        _antd.Col,
	                        { span: 20 },
	                        _react2['default'].createElement(
	                            'p',
	                            { className: 'gutter' },
	                            _react2['default'].createElement(
	                                'a',
	                                { className: 'author', onClick: _this.props.onSelectAuthor },
	                                _this.props.author,
	                                ' '
	                            ),
	                            '  .  ',
	                            _react2['default'].createElement(
	                                'a',
	                                { className: 'createDate' },
	                                _this.props.createDate
	                            )
	                        ),
	                        _react2['default'].createElement(
	                            'h3',
	                            { className: 'title gutter' },
	                            _react2['default'].createElement(
	                                'a',
	                                { onClick: _this.props.onSelect },
	                                _this.props.title
	                            )
	                        ),
	                        _react2['default'].createElement(
	                            'p',
	                            { className: 'gutter foot' },
	                            _react2['default'].createElement(
	                                'a',
	                                { className: 'read', onClick: _this.props.onSelect },
	                                '阅读 ',
	                                _this.props.read
	                            ),
	                            _react2['default'].createElement(
	                                'a',
	                                { className: 'comment', onClick: _this.props.onSelect },
	                                '评论 ',
	                                _this.props.comment
	                            ),
	                            _react2['default'].createElement(
	                                'a',
	                                { className: 'like' },
	                                '赞 ',
	                                _this.props.like
	                            ),
	                            _react2['default'].createElement(
	                                'a',
	                                { className: 'dislike' },
	                                '踩 ',
	                                _this.props.dislike
	                            )
	                        )
	                    ),
	                    _react2['default'].createElement(
	                        _antd.Col,
	                        { span: 4 },
	                        '图片'
	                    )
	                )
	            );
	        };
	    }

	    _createClass(ListItem, null, [{
	        key: 'defaultProps',
	        value: {},
	        enumerable: true
	    }]);

	    return ListItem;
	})(_react2['default'].Component);

	exports['default'] = ListItem;
	module.exports = exports['default'];

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(7); if (makeExportsHot(module, __webpack_require__(1))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ListItem.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(9)(module)))

/***/ },

/***/ 405:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(8), RootInstanceProvider = __webpack_require__(6), ReactMount = __webpack_require__(3), React = __webpack_require__(1); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	/**
	 * Created by XK on 2016/6/28.
	 */
	'use strict';

	Object.defineProperty(exports, '__esModule', {
	    value: true
	});

	var _createClass = (function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ('value' in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; })();

	var _get = function get(_x, _x2, _x3) { var _again = true; _function: while (_again) { var object = _x, property = _x2, receiver = _x3; desc = parent = getter = undefined; _again = false; if (object === null) object = Function.prototype; var desc = Object.getOwnPropertyDescriptor(object, property); if (desc === undefined) { var parent = Object.getPrototypeOf(object); if (parent === null) { return undefined; } else { _x = parent; _x2 = property; _x3 = receiver; _again = true; continue _function; } } else if ('value' in desc) { return desc.value; } else { var getter = desc.get; if (getter === undefined) { return undefined; } return getter.call(receiver); } } };

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { 'default': obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError('Cannot call a class as a function'); } }

	function _inherits(subClass, superClass) { if (typeof superClass !== 'function' && superClass !== null) { throw new TypeError('Super expression must either be null or a function, not ' + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	var _react = __webpack_require__(1);

	var _react2 = _interopRequireDefault(_react);

	var _reactRedux = __webpack_require__(17);

	var _reduxRouter = __webpack_require__(19);

	__webpack_require__(347);

	var Tab = (function (_React$Component) {
	    _inherits(Tab, _React$Component);

	    function Tab() {
	        var _this = this;

	        _classCallCheck(this, Tab);

	        _get(Object.getPrototypeOf(Tab.prototype), 'constructor', this).apply(this, arguments);

	        this.render = function () {
	            return _react2['default'].createElement(
	                'div',
	                null,
	                _react2['default'].createElement(
	                    'a',
	                    { onClick: _this.props.onSelect, className: 'tab' },
	                    _this.props.text
	                )
	            );
	        };
	    }

	    _createClass(Tab, null, [{
	        key: 'defaultProps',
	        value: {
	            text: ""
	        },
	        enumerable: true
	    }]);

	    return Tab;
	})(_react2['default'].Component);

	exports['default'] = Tab;
	module.exports = exports['default'];

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(7); if (makeExportsHot(module, __webpack_require__(1))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Tab.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(9)(module)))

/***/ },

/***/ 413:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(8), RootInstanceProvider = __webpack_require__(6), ReactMount = __webpack_require__(3), React = __webpack_require__(1); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	/**
	 * Created by xgz on 16/5/18.
	 */
	'use strict';

	Object.defineProperty(exports, '__esModule', {
	    value: true
	});

	var _createClass = (function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ('value' in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; })();

	var _get = function get(_x, _x2, _x3) { var _again = true; _function: while (_again) { var object = _x, property = _x2, receiver = _x3; desc = parent = getter = undefined; _again = false; if (object === null) object = Function.prototype; var desc = Object.getOwnPropertyDescriptor(object, property); if (desc === undefined) { var parent = Object.getPrototypeOf(object); if (parent === null) { return undefined; } else { _x = parent; _x2 = property; _x3 = receiver; _again = true; continue _function; } } else if ('value' in desc) { return desc.value; } else { var getter = desc.get; if (getter === undefined) { return undefined; } return getter.call(receiver); } } };

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { 'default': obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError('Cannot call a class as a function'); } }

	function _inherits(subClass, superClass) { if (typeof superClass !== 'function' && superClass !== null) { throw new TypeError('Super expression must either be null or a function, not ' + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	var _react = __webpack_require__(1);

	var _react2 = _interopRequireDefault(_react);

	var _reactRedux = __webpack_require__(17);

	var _reduxRouter = __webpack_require__(19);

	var _redux = __webpack_require__(22);

	var _libComponentTabJs = __webpack_require__(405);

	var _libComponentTabJs2 = _interopRequireDefault(_libComponentTabJs);

	var _libComponentListJs = __webpack_require__(403);

	var _libComponentListJs2 = _interopRequireDefault(_libComponentListJs);

	var _libComponentListItemJs = __webpack_require__(404);

	var _libComponentListItemJs2 = _interopRequireDefault(_libComponentListItemJs);

	var _antd = __webpack_require__(51);

	var TabPane = _antd.Tabs.TabPane;

	var AllPostsPage = (function (_Component) {
	    _inherits(AllPostsPage, _Component);

	    function AllPostsPage() {
	        var _this2 = this;

	        _classCallCheck(this, AllPostsPage);

	        _get(Object.getPrototypeOf(AllPostsPage.prototype), 'constructor', this).apply(this, arguments);

	        this.state = {};

	        this.renderItem = function (item) {
	            console.log("=======");
	            return _react2['default'].createElement(_libComponentListItemJs2['default'], {
	                author: item.author,
	                title: item.title,
	                createDate: item.CreateDate,
	                read: item.read,
	                like: item.like,
	                comment: item.comment,
	                dislike: item.dislike
	            });
	        };

	        this.renderTech = function () {
	            console.log("咋出不来");
	            var _this = _this2;
	            return _react2['default'].createElement(
	                'div',
	                null,
	                _react2['default'].createElement(_libComponentTabJs2['default'], { key: 'hot', text: '热门', onSelect: _this.handleSelect }),
	                _react2['default'].createElement(_libComponentTabJs2['default'], { key: 'java', text: 'JAVA', onSelect: _this.handleSelect }),
	                _react2['default'].createElement(_libComponentTabJs2['default'], { key: 'web', text: 'WEB前端', onSelect: _this.handleSelect }),
	                _react2['default'].createElement(_libComponentTabJs2['default'], { key: 'ios', text: 'IOS', onSelect: _this.handleSelect }),
	                _react2['default'].createElement(_libComponentTabJs2['default'], { key: 'android', text: '安卓', onSelect: _this.handleSelect })
	            );
	        };

	        this.renderGossip = function () {
	            var _this = _this2;
	            return _react2['default'].createElement(
	                'div',
	                null,
	                _react2['default'].createElement(_libComponentTabJs2['default'], { key: 'bigbang', text: '劲爆', onSelect: _this.handleSelect }),
	                _react2['default'].createElement(_libComponentTabJs2['default'], { key: 'alibaba', text: '阿里系', onSelect: _this.handleSelect }),
	                _react2['default'].createElement(_libComponentTabJs2['default'], { key: 'tencent', text: '腾讯系', onSelect: _this.handleSelect }),
	                _react2['default'].createElement(_libComponentTabJs2['default'], { key: 'baidu', text: '百度系', onSelect: _this.handleSelect }),
	                _react2['default'].createElement(_libComponentTabJs2['default'], { key: 'more', text: '更多', onSelect: _this.handleSelect })
	            );
	        };
	    }

	    _createClass(AllPostsPage, [{
	        key: 'componentWillMount',
	        value: function componentWillMount() {}
	    }, {
	        key: 'componentDidMount',
	        value: function componentDidMount() {}
	    }, {
	        key: 'componentWillUnmount',
	        value: function componentWillUnmount() {}
	    }, {
	        key: 'componentWillReceiveProps',
	        value: function componentWillReceiveProps(nextProps) {}
	    }, {
	        key: 'render',
	        value: function render() {
	            console.log("props", this.props);
	            var _this = this;
	            var items = [{ title: "阿里天使投资人与蘑菇街CEO的秘密", author: "顾一宸", CreateDate: "3月之前", read: " 7101", comment: " 191", like: "246", dislike: "10" }, { title: "干货又来了！提高英语听力秘诀+关键+工具）", CreateDate: "顾一宸", time: "3月之前", read: " 7101", comment: " 191", like: "246", dislike: "10" }, { title: "你这么怂，我看还是别上班了！", author: "顾一宸", CreateDate: "3月之前", read: " 7101", comment: " 191", like: "246", dislike: "10" }, { title: "读完这本书，让你更加了解情爱", author: "顾一宸", CreateDate: "3月之前", read: " 7101", comment: " 191", like: "246", dislike: "10" }, { title: "简书早报160628——《修德、网吧、师徒，今天不讲道理讲故事》", author: "顾一宸", CreateDate: "3月之前", read: " 7101", comment: " 191", like: "246", dislike: "10" }, { title: "他们的文章很有趣，值得你关注", author: "顾一宸", CreateDate: "3月之前", read: " 7101", comment: " 191", like: "246", dislike: "10" }, { title: "我们始终是爱自己，胜过爱爱情", author: "顾一宸", CreateDate: "3月之前", read: " 7101", comment: " 191", like: "246", dislike: "10" }, { title: "既见君子，云胡不喜？", author: "顾一宸", CreateDate: "3月之前", read: " 7101", comment: " 191", like: "246", dislike: "10" }, { title: "女为悦己者容，更为悦自己容", author: "顾一宸", CreateDate: "3月之前", read: " 7101", comment: " 191", like: "246", dislike: "10" }];
	            return _react2['default'].createElement(
	                'div',
	                null,
	                _react2['default'].createElement(
	                    _antd.Row,
	                    null,
	                    _react2['default'].createElement(
	                        _antd.Col,
	                        { span: 24 },
	                        _this.props.type == 1 ? _this.renderTech() : _this.renderGossip()
	                    )
	                ),
	                _react2['default'].createElement(
	                    _antd.Row,
	                    { style: { marginTop: "20px" } },
	                    _react2['default'].createElement(
	                        _antd.Col,
	                        { span: 24 },
	                        _react2['default'].createElement(
	                            _libComponentListJs2['default'],
	                            null,
	                            items.map(function (item) {
	                                return _this.renderItem(item);
	                            })
	                        )
	                    )
	                )
	            );
	        }
	    }], [{
	        key: 'defaultProps',
	        value: {
	            content: []

	        },
	        enumerable: true
	    }, {
	        key: 'propTypes',
	        value: {
	            title: _react2['default'].PropTypes.string,
	            content: _react2['default'].PropTypes.array

	        },
	        enumerable: true
	    }]);

	    return AllPostsPage;
	})(_react.Component);

	function mapStateToProps(state) {
	    console.log("props", state);
	    return { q: state.router.location.query.q };
	}

	function mapDispatchToProps(dispatch) {
	    return {
	        dispath: dispatch,
	        //actions: bindActionCreators(DocsCreators, dispatch),
	        pushState: (0, _redux.bindActionCreators)(_reduxRouter.pushState, dispatch)
	    };
	}

	exports['default'] = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(AllPostsPage);
	module.exports = exports['default'];
	/* <Tab key="hot" text="热门" onSelect={_this.handleSelect}></Tab>
	<Tab key="java" text="JAVA" onSelect={_this.handleSelect}></Tab>
	<Tab key="web" text="WEB前端" onSelect={_this.handleSelect}></Tab>
	<Tab key="ios" text="IOS" onSelect={_this.handleSelect}></Tab>
	<Tab key="android" text="安卓" onSelect={_this.handleSelect}></Tab>*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(7); if (makeExportsHot(module, __webpack_require__(1))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "AllPostsPage.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(9)(module)))

/***/ },

/***/ 414:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(8), RootInstanceProvider = __webpack_require__(6), ReactMount = __webpack_require__(3), React = __webpack_require__(1); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	/**
	 * Created by xgz on 16/5/18.
	 */
	'use strict';

	Object.defineProperty(exports, '__esModule', {
	    value: true
	});

	var _createClass = (function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ('value' in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; })();

	var _get = function get(_x, _x2, _x3) { var _again = true; _function: while (_again) { var object = _x, property = _x2, receiver = _x3; desc = parent = getter = undefined; _again = false; if (object === null) object = Function.prototype; var desc = Object.getOwnPropertyDescriptor(object, property); if (desc === undefined) { var parent = Object.getPrototypeOf(object); if (parent === null) { return undefined; } else { _x = parent; _x2 = property; _x3 = receiver; _again = true; continue _function; } } else if ('value' in desc) { return desc.value; } else { var getter = desc.get; if (getter === undefined) { return undefined; } return getter.call(receiver); } } };

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj['default'] = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { 'default': obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError('Cannot call a class as a function'); } }

	function _inherits(subClass, superClass) { if (typeof superClass !== 'function' && superClass !== null) { throw new TypeError('Super expression must either be null or a function, not ' + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	var _react = __webpack_require__(1);

	var _react2 = _interopRequireDefault(_react);

	var _actionsLoginActionsJs = __webpack_require__(116);

	var Login = _interopRequireWildcard(_actionsLoginActionsJs);

	var _reactRedux = __webpack_require__(17);

	var _reduxRouter = __webpack_require__(19);

	var _redux = __webpack_require__(22);

	var _AllPostsPage = __webpack_require__(413);

	var _AllPostsPage2 = _interopRequireDefault(_AllPostsPage);

	var _antd = __webpack_require__(51);

	var TabPane = _antd.Tabs.TabPane;

	var ContentLayout = (function (_Component) {
	    _inherits(ContentLayout, _Component);

	    function ContentLayout() {
	        var _this2 = this;

	        _classCallCheck(this, ContentLayout);

	        _get(Object.getPrototypeOf(ContentLayout.prototype), 'constructor', this).apply(this, arguments);

	        this.state = {
	            gossip: false
	        };

	        this.callback = function (key) {
	            console.log(key);
	            key == "gossip" ? _this2.setState({ gossip: true }) : _this2.setState({ gossip: false });
	            //this.props.pushState(null,"/client/page/content/")
	            //document.location.href = `/client/page/content/${key}`
	        };

	        this.renderAllPosts = function () {
	            var type = undefined;
	            type = _this2.state.gossip ? 2 : 1;
	            return _react2['default'].createElement(_AllPostsPage2['default'], { type: type });
	        };

	        this.renderGossip = function () {
	            return _react2['default'].createElement(_AllPostsPage2['default'], null);
	        };
	    }

	    _createClass(ContentLayout, [{
	        key: 'componentWillMount',
	        value: function componentWillMount() {
	            /*  let account = "yanan";
	            let password = "8371593";
	            this.props.actions.Enter(account,password,(err,res)=>{
	                console.log("---------------")
	                console.log(res);
	            })*/
	        }
	    }, {
	        key: 'componentDidMount',
	        value: function componentDidMount() {}
	    }, {
	        key: 'componentWillUnmount',
	        value: function componentWillUnmount() {}
	    }, {
	        key: 'componentWillReceiveProps',
	        value: function componentWillReceiveProps(nextProps) {}
	    }, {
	        key: 'render',
	        value: function render() {
	            var _this = this;
	            return _react2['default'].createElement(
	                _antd.Row,
	                null,
	                _react2['default'].createElement(
	                    _antd.Col,
	                    { xs: { span: 0 }, sm: { span: 5 }, lg: { span: 6 }, style: { position: "fixed" } },
	                    _react2['default'].createElement('img', { src: __webpack_require__(363), style: { width: "100%", height: window.screen.availHeight } }),
	                    _react2['default'].createElement(
	                        'div',
	                        { style: { position: "fixed", bottom: "10%", color: "#fff", opacity: "0.8", paddingLeft: "14px", fontFamily: '"lucida grande", "lucida sans unicode", lucida, helvetica, "Hiragino Sans GB", "Microsoft YaHei", "WenQuanYi Micro Hei", sans-serif' } },
	                        _react2['default'].createElement(
	                            'h1',
	                            { style: { lineHeight: "50px", fontSize: "30px" } },
	                            'IT老炮'
	                        ),
	                        _react2['default'].createElement(
	                            'h3',
	                            { style: { lineHeight: "30px", fontSize: "20px" } },
	                            '上班嚼干货，下班聊八卦'
	                        ),
	                        _react2['default'].createElement(
	                            'p',
	                            { style: { lineHeight: "30px", fontSize: "11px" } },
	                            '一个集内涵与深度于一体的IT社区'
	                        ),
	                        _react2['default'].createElement(
	                            'a',
	                            { 'class': 'btn btn btn-large btn-success', id: 'write-button', 'data-signin-link': 'true', 'data-toggle': 'modal', style: { textAlign: "center", padding: "5px", lineHeight: "40px", fontSize: "14px", color: "#fff", backgroundColor: "#49BE38", borderRadius: "5px" } },
	                            _react2['default'].createElement(_antd.Icon, { type: 'edit' }),
	                            '  提笔写篇文章'
	                        )
	                    )
	                ),
	                _react2['default'].createElement(
	                    _antd.Col,
	                    { xs: { span: 24, offset: 0 }, sm: { span: 19, offset: 5 }, lg: { span: 18, push: 2 } },
	                    _react2['default'].createElement(
	                        _antd.Row,
	                        null,
	                        _react2['default'].createElement(
	                            _antd.Col,
	                            { xs: { span: 24, offset: 0 }, sm: { span: 16 } },
	                            _react2['default'].createElement(
	                                _antd.Tabs,
	                                { defaultActiveKey: 'tech', onChange: _this.callback },
	                                _react2['default'].createElement(
	                                    TabPane,
	                                    { tab: '上班时间看干货', key: 'tech' },
	                                    _this.renderAllPosts()
	                                ),
	                                _react2['default'].createElement(
	                                    TabPane,
	                                    { tab: '闲暇看八卦', key: 'gossip' },
	                                    _this.state.gossip ? _this.renderGossip() : _this.props.children
	                                )
	                            )
	                        ),
	                        _react2['default'].createElement(
	                            _antd.Col,
	                            { xs: { span: 0, offset: 0 }, sm: { span: 8 } },
	                            _react2['default'].createElement(
	                                'div',
	                                { style: { position: "relative", left: "60%", top: "10px", color: "#fff" } },
	                                _react2['default'].createElement(
	                                    'button',
	                                    { style: { width: "60px", height: "30px", lineHeight: "30px", position: "absolute", top: "0", borderRadius: "30px 30px 0 0", backgroundColor: "#2DB7F5", border: "none", borderBottom: "1px solid #D9D9D9 " } },
	                                    '注册'
	                                ),
	                                _react2['default'].createElement(
	                                    'button',
	                                    { style: { width: "60px", height: "30px", lineHeight: "30px", position: "absolute", top: "30px", borderRadius: "0px 0px 30px 30px", backgroundColor: "#2DB7F5", border: "none" } },
	                                    '登录'
	                                )
	                            )
	                        )
	                    )
	                )
	            );
	        }
	    }], [{
	        key: 'defaultProps',
	        value: {},
	        enumerable: true
	    }, {
	        key: 'propTypes',
	        value: {
	            title: _react2['default'].PropTypes.string
	        },
	        enumerable: true
	    }]);

	    return ContentLayout;
	})(_react.Component);

	function mapStateToProps(state) {

	    return { q: state.router.location.query.q };
	}

	function mapDispatchToProps(dispatch) {
	    return {
	        dispath: dispatch,
	        actions: (0, _redux.bindActionCreators)(Login, dispatch),
	        pushState: (0, _redux.bindActionCreators)(_reduxRouter.pushState, dispatch)
	    };
	}

	exports['default'] = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(ContentLayout);
	module.exports = exports['default'];
	/**/ /**/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(7); if (makeExportsHot(module, __webpack_require__(1))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ContentLayout.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(9)(module)))

/***/ }

});