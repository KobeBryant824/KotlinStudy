## Number ##
- Byte 8
- Short 16
- Int 32
- Long 64
- Float 32
- Double 64


## var、val ##
    const val DEBUG = true //const 编译期常量，会直接替换value，建议大量使用的常量使用const修饰
    fun main(args: Array<String>) {
        var a = 1 //声明变量，自动推断为Int数据类型
        val b = "Kotlin" //声明常量，不可再重新初始化
        println(a.javaClass)
        println(b.javaClass)
    }


## 函数 ##
函数强调功能本身，不考虑从属；方法的称呼通常是从类的角度出发。

    //main函数，无返回值为Unit可不写
    fun main(args: Array<String>) {
        println(plus1(1, "Hello"))
        println(plus2(a = 1, b = "Hello")) //具名参数，给参数的实参附上形参
        println(plus3(b = "Hello")) //可变参数，即多参数，传参有歧义时需要使用具名参数
    }
    
    //函数写法1
    fun plus1(a: Int, b: String): String {
        return a.toString() + b
    }
    
    //函数写法2（用一个表达式就可以写出来）
    fun plus2(a: Int, b: String) = a.toString() + b
    
    //a: Int = 1为默认参数, 可以省掉写一堆重载函数
    fun plus3(a: Int = 1, b: String) = a.toString() + b


### Lambda ###
lambda表达式:匿名函数，当Java函数的形参是个接口且只有一个抽象方法可以用lambda代替

    写法：{[参数列表] -> [函数体，最后一行是返回值}
    () -> unit：无参，返回值为unit
    (Int) -> Int:传入Int，返回Int
    (String,(String) -> String) -> Boolean:传入String，Lambda表达式，返回Boolean

 lambda的简化

    当参数只有一个时，it代表参数，可以只写方法体
    函数参数只有一个lambda，调用时可以去除小括号
    入参、入参的返回值与形参一致的函数可以用函数引用的方式作为实参传入：
        fun main(args: Array<String>) {
            args.forEach { println(it) }
            //forEach 形参是(action: (T) -> Unit) ，lambda也是一个对象，既是Any的子类，foreach 返回值是Unit
            //println 形参是(message: Any?)，返回值也是Unit
            // 此时，foreach的入参和println的入参都是Any，返回值也都是Unit，可以用方法引用代替
            args.forEach(::println)
        }


### 函数式表达式 ###
    fun main(args: Array<String>) {
        println(add(1, 2))

        // var 不仅可以声明变量，也可以声明函数
        val i = { x: Int, y: Int -> x + y } //写法1，直接用一个lambda表示
        println(i(1, 2))

        val j = fun(x: Int, y: Int) = x + y //写法2
        println(j(1, 2))

        val k: (Int, Int) -> Int = { x, y -> x + y }//写法3
        println(k(1, 2))
    }

    fun add(x: Int, y: Int) = x + y
    

## 换行 ##
    fun main(args: Array<String>) {
        //val str1 = """abcd"""//直接打六个" 在每个字符后回车
        val str = """a
            |b
            |c
            |d""".trimMargin()
        println(str)
    }


## io ##
    fun main(args: Array<String>) {
        File("build.gradle").readLines().forEach(::println) //小文件

        BufferedReader(FileReader("build.gradle")).use { //Closeable，可自动关闭io
            var line :String
            while (true){
                line = it.readLine()?:break
                println(line)
            }

        }
    }


## $ 、!!  ##
    fun main(args: Array<String>) {
        println("请输入第一个数")
        var a = readLine() //键盘录入
        println("请输入第二个数")
        var b = readLine()
        //${}字符串模版
        //!!非空判断
        println("${a}+" + "${b}=" + "${a!!.toInt() + b!!.toInt()}")
    }


## ==、equal ##
    //字符串比较
    fun main(args: Array<String>) {
        var str1 = "kotlin"
        var str2 = "Kotlin"
        println(str1 == str2)
        println(str1.equals(str2))
        println(str1.equals(str2, true)) //第二个参数为true代表忽略大小写

        var str3 = "java"
        var str4: String = String(charArrayOf('j', 'a', 'v', 'a'))
        println(str3 === str4) //判断对象是否相同，等价于java的==
    }


## null、? 、!! ##
    fun main(args: Array<String>) {
      val string: String? = null
      println(string?.length)//如果为null直接给我返回null不抛异常了
      println(string!!.length)//!!程序员自己已知必定不会为null使用，为null还是会抛异常

      nullCheck(null)
    }

    //Kotlin 函数默认接收是非空对象，?显示声明可接受null对象
    fun nullCheck(str: String?) = str

## 分支表达式 ##

### if、else ###
    fun checkAge(age: Int) = if (age > 18) "成年人" else "未成年人"


### 三元表达式 ###
    val text = if (x > 5) "大于5了" else "小于5了" //Java 用?


### when ###
    fun main(args: Array<String>) {
        println(switchGrade(0))
    }

    //Java switch的加强版，支持任意类型，支出纯表达式条件分支（lambda表达式），有返回值
    fun switchGrade(age: Int): String {
        return when (age) {
            //is Int -> println("不执行后面了")
            7 -> "一年级"
            8 -> "二年级"
            9 -> "三年级"
            10 -> "四年级"
            11 -> "五年级"
            12 -> "六年级"
            in 0..6 -> "幼儿园小朋友"
            else -> "大朋友" //default
        }
    }


## for、loop、Range ##
    fun main(args: Array<String>) {
        var nums1 = 1..100 //[1,100]
        println(nums1.javaClass) //IntRange
        for (i in nums1 ){
            println(i)
        }

        var nums2 = 1 until 100 //[1,100)100开区间
        var nums3 = nums2.reversed() //反转
        for (i in nums3 step 2){ //loop循环, step每次i跳过几步
            //step 2,中缀表达式,其实是Kotlin方法的一种语法糖，一个方法如果在声明时有一个infix修饰符，那么它可以使用中缀语法调用。
            println(i)
        }
    }

## infix ##
    fun main(args: Array<String>) {
        //-name <Name>
        if("-name" in args){
            println(args[args.indexOf("-name") + 1])
        }

        if(Book() on Desk()){ // 用在dsl 比较多

        }
    }

    class Book{
        //中缀表达式
        infix fun on(any: Any): Boolean{
            return false
        }
    }

    class Desk


## operator ##
    fun main(args: Array<String>) {
        val a = Complex(1.0, 10.0)
        val b = Complex(3.0, 30.0)
        println(a + b)
        println("${a + 3}")
        println(a + "hello")
        println(a.invoke())
    }

    //自定义运算符
    class Complex(var real: Double, var imaginary: Double) {
        operator fun plus(other: Complex): Complex =
                Complex(real + other.real, imaginary + other.imaginary)

        operator fun plus(other: Int): Complex = Complex(real + other, imaginary)

        operator fun plus(other: Any): Int = real.toInt()

        operator fun invoke(): Double = Math.hypot(real, imaginary)

        override fun toString(): String = "$real + ${imaginary}i"
    }


## array ##
    val arrayOfInt: IntArray = intArrayOf(1, 3, 5, 7) //定制的基本类型数组，避免装箱拆箱
    val arrayOfChar: CharArray = charArrayOf('H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd')
    val arrayOfString: Array<String> = arrayOf("我", "是", "码农")
    val arrayOfPerson: Array<Person> = arrayOf(Person("张"), Person("李"), Person("王"))

    fun main(args: Array<String>) {
        println(arrayOfChar.joinToString()) //把字符数组里的所有元素连成一串
        println(arrayOfInt.slice(1..2)) //截取
    }

    class Person(var name: String)


## list ##
    fun main(args: Array<String>) {
        //kotlin 的listof、setof、mapof大小不可变，没有put、add、remove
        //只有MutableList、MutableSet、MutableMap是跟Java一样的
        var lists = listOf("Java", "Kotlin", "C#", "Phyon")
        for (list in lists) {
            println(list)
        }
        for (list in lists.withIndex()) {
            println("${list.index}    ${list.value}")// list javaClass -> IndexedValue
        }
        for ((i, v) in lists.withIndex()) {
            println("$i    $v")
        }
    }


## map ##
    fun main(args: Array<String>) {
        val map = mapOf(Pair(1, "Kotlin"), Pair(2, "Java"), Pair(3, "C#"))
        val map1 = mapOf(1 to "Kotlin", 2 to "Java", 3 to "C#")//java9

        for ((k, v) in map) println("$k     $v")
        for (entry in map1) println(entry)

        val treeMap = TreeMap<String, String>()
        treeMap["Kobe"] = "科比"
        treeMap["Yao"] = "姚明"
        treeMap["Curry"] = "库里"

        for (entry in treeMap) println(entry)
        println(treeMap["Kobe"])
    }


## tailrec ##
    fun main(args: Array<String>) {
    //    println(ollAdd(10000)) // StackOverflowError
        println(ollAddTailrec(1000000, 0))
    }
    
    //累加操作 5->5+4+3+2+1
    fun ollAdd(num: Int): Int { 
        println("第 ${num}  次计算")
        if (num == 1) return 1
        else return num + ollAdd(num - 1)
    }
    
    //tailrec尾递归优化
    tailrec fun ollAddTailrec(num: Int, result: Int): Int {
        println("第 ${num}  次计算, result= ${result}")
        if (num == 0) return 1
        else return ollAddTailrec(num - 1, result + num)
    }


## class ##
    fun main(args: Array<String>) {
        val kobe = Person("Kobe", "男", 38, "打篮球")
        println(kobe.toString())
        kobe.smile()
        println(kobe.selfIntroduction())
    }

    class Person(var name: String, var sex: String, var age: Int, var favorite: String = "吃饭睡觉") {
        init {
            //这是构造方法的方法体
            println("new 了一个 Person(name='$name', age=$age, favorite='$favorite')")
        }

        fun smile() {
            println("哈哈")
        }

        fun selfIntroduction(): String {
            return "我叫${name} ，今年${age}岁，爱好是${favorite}"
        }

        override fun toString(): String {
            return "Person(name='$name', age=$age, favorite='$favorite')"
        }
    }


### lateinit、lazy ###
    //延迟初始化
    class Man {
        lateinit var name: String
        val sex: String by lazy { "男" }
        var age: Int = 0
    }


### data class ###
    fun main(args: Array<String>) {
        //val person = Person()//这里还是要传入参数，因为插件是在编译期修改的，编译前不能识别无参构造,只能使用反射了,相当于用data class必须传参了或者用默认参数了
        //这里得用class了
        val kobe1 = Person1(name = "Kobe", age = 38)
        println("${kobe1.name} ${kobe1.sex} ${kobe1.age} ${kobe1.favorite}")

        val kobe2 = Person1()
        kobe2.name = "Curry"
        kobe2.sex = "nan"
        kobe2.age = 28
        kobe2.favorite = "basketball"
        println(kobe2)
    }

    //相当于JavaBean,已自动set/get/toString()
    //编译后是final class ，private constructor()，相当于不能new Person2()，严格讲还不是JavaBean，可以用allopen、noargs 插件修改字节码
    @PoKo
    data class Person(var name: String, var sex: String, var age: Int, var favorite: String = "吃饭睡觉")

    class Person1 constructor() {
        lateinit var name: String
        lateinit var sex: String
        lateinit var favorite: String
        var age: Int = 0

        //在构造方法里用var、val修饰的都是属性（有set、get）,否则是参数
        //第二构造方法，只能输入参数
        constructor(name: String, sex: String = "男", age: Int, favorite: String = "吃饭睡觉") : this() {
            this.name = name
            this.sex = sex
            this.age = age
            this.favorite = favorite
        }

        override fun toString(): String {
            return "Person1(name='$name', sex='$sex', favorite='$favorite', age=$age)"
        }

    }


### inner class ###
    open class Outter0{
        companion object {
            val a: Int = 0
        }

        class Inner{ //Kotlin默认的内部类是静态的，要想像Java的内部类那样则需要加inner 修饰
            fun hello(){
                println(a)
            }
        }
    }

    open class Outter{
        val a: Int = 0

        inner class Inner{
            val a: Int = 5

            fun hello(){
                println(this@Outter.a)
            }
        }
    }

    interface OnClickListener{
        fun onClick()
    }

    class MyView {
        var onClickListener: OnClickListener? = null
    }

    fun main(args: Array<String>) {
        Outter0.Inner().hello()
        Outter().Inner().hello()

        val myView = MyView()
        myView.onClickListener = object : Outter(), OnClickListener{ //匿名内部类
            override fun onClick() {

            }
        }

    }


### enum class ###
    fun main(args: Array<String>) {
        Direction.values().forEach { println("${it.name} ${it.ordinal}") }
    }

    //枚举类,实例可数，更在意数据，可以提升代码表现力，但也会有性能开销，安卓建议用常量
    enum class Direction {
        TOP, BOTTOM, LEFT, RIGHT
    }


### sealed class ###
    //密封类,用于限定子类类型（子类可数），更在意数据类型
    //适用于指令，传参
    sealed class PlayerCmd {
        class Play(val url: String, val position: Long = 0): PlayerCmd()

        class Seek(val position: Long): PlayerCmd()

        object Pause: PlayerCmd()

        object Resume: PlayerCmd()

        object Stop: PlayerCmd()
    }

    //适用于状态
    enum class PlayerState{
        IDLE, PAUSE, PLAYING
    }


### abstract ###
    fun main(args: Array<String>) {
        ChineseDog("中华田园犬").bark()
        TibetanDog("藏獒").bark()
    }

    abstract class Dog(name:String){
        abstract fun bark()
    }

    class ChineseDog(val name: String) :Dog(name){
        override fun bark() {
            println("${name}旺旺旺的叫")
        }
    }

    class TibetanDog(val name: String) :Dog(name){
        override fun bark() {
            println("${name}嗷嗷嗷的叫")
        }
    }


## object ##
    fun main(args: Array<String>) {
        var xiaoHuang = Human()
        xiaoHuang.buyIphoneX()
    }
    
    interface BuyPhone{
        fun buyIphoneX()
    }
    
    //by：委托给Cattle
    class Human:BuyPhone by Cattle(){
        override fun buyIphoneX() {
            println("找黄牛预约，不用去通宵排队")
            Cattle().buyIphoneX()
            println("开心的交钱拿到手机了")
        }
    }
    
    //代理了Human
    //object 单例，确保预约和交钱的是同一个黄牛
    object Cattle :BuyPhone{ 
        override fun buyIphoneX() {
            println("通宵蹲点，买苹果手机")
        }
    }


### companion object ###
    //伴生对象是在类加载的时候初始化的，相当于java中的静态内部类（kotlin没有static关键字）
    class Person{
        //如果与类没有关联用包级函数
        companion object {
            //伴生对象里可声明常量、方法
            @JvmStatic //Java 调用需要加这个
            val GITHUB_URL = "https://github.com/KobeBryant824"
            fun sayHello(){}
        }
    }


##  interface ##
    fun main(args: Array<String>) {
       var lists = listOf(Man(),TaiJian())//多态
        for (human in lists) {
            human.eat()
            if (human is IMan) human.xiaodidi()//is ：java 的 instanceof
        }
    }

    abstract class Human(){
        abstract fun eat()
    }

    interface IMan {
        fun xiaodidi()
    }

    class Man :Human(),IMan{
        override fun xiaodidi() {
            println("我有18cm的小弟弟")
        }

        override fun eat() {
            println("自己做饭吃")
        }
    }

    class TaiJian :Human(){
        override fun eat() {
            println("吃宫里的")
        }
    }


## override、 : ##
    fun main(args: Array<String>) {
        var pixel = Pixel()
        println("${pixel.cpu}    ${pixel.call()}")
    }

    open class AndroidPhone{
        var cpu = 32
        open fun call() =  "打电话"
    }

    class Pixel :AndroidPhone(){    //:继承
        override fun call() = "摇一摇打电话" //重载
    }


    ## as ##
        fun main(args: Array<String>) {
            val parent: Parent = Parent()

            val child: Child? = parent as? Child //as:强制类型转换，?:转换失败返回null，不抛异常
            println(child?.printChild())
        }

        open class Parent

        open class Child : Parent(){

            fun printChild() {
                println(this.javaClass.simpleName)
            }
        }


## internal ##
    fun main(args: Array<String>) {
        val internalClass = InternalClass()
        internalClass.printlnHello()//在模块内即使用internal 修饰函数依然能访问，但java 就不能访问该方法了
    }

    //模块Module内部私有，可修饰class、 fun
    internal class InternalClass {
        internal fun printlnHello() {
            println("Hello")
        }
    }


## inline ##
    //内联函数与一般的函数不同，在编译时会做替换，少了普通函数调用的压栈出栈，更高效，但函数体不宜过大。因为是替换，所以可以识别传入的泛型
    //内联函数最好的好处就是直接内联Lambda，不产生匿名内部类对象。这是一个非常黑的黑科技，减少Lambda对象的数量可以既保证函数式的优美代码，又不必为Lambda对象的开销买单。
    inline fun <reified T : Activity> Activity.pushPage(bundle: Bundle) {
        val intent = Intent(this, T::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }


## 扩展函数 ##
    //扩展函数允许我们在不改变已有类的情况下，为类添加新的函数，比如为Activity添加简单toast
    //Context:扩展函数的所属对象
    //. :扩展函数修饰符
    //toast：扩展函数的名称
    //在有Context地方直接调用 toast("kotlin")
    fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }


## 高阶函数 ##
传入或者返回函数的函数


### forEach ###
    //用于迭代、遍历
    fun main(args: Array<String>) {
        var lists = listOf("Java", "Kotlin", "C#", "Phyon")
        lists.forEach { println(it) } //接收一个Lambda，无返回值
    }


### map、flatMap ###
    //用于映射、转换
    fun main(args: Array<String>) {
        val map = mapOf(1 to "Kotlin", 2 to "Java", 3 to "C#") //LinkedHashMap
        val map1 = map.map { it.key.toString() + ":" + it.value } //遍历返回一个List<R>
        map.forEach { println(it) }
        map1.forEach { println(it) }
    }

    fun main(args: Array<String>) {
        //flapMap 用于将原Iterable<T> （打平） 转换 成另一种Iterable<R>
        var lists = listOf(1..20, 5..10,10..50)
        //var flatMap = lists.flatMap { intRange -> intRange.map { it } }//简写成下面
        var flatMap = lists.flatMap { it }
        println(flatMap)
        flatMap.forEach { println(it) }
    }


### reduce ###
    //累加，从第一项到最后一项
    fun main(args: Array<String>) {
        var map = (0..5).map(::factorial)
        map.forEach { println(it) }
        println(map.reduce { acc, i -> acc + i })//累加求和
    }

    fun factorial(n: Int): Int {
        if (n == 0) return 0
        return (1..n).reduce { acc, i -> acc * i } //累加求阶乘
    }


### hold、joinToString ###
    //拼接
    fun main(args: Array<String>) {
        println((0..5).fold(StringBuilder(), { acc, i -> acc.append(i).append(",") }))
        println((0..5).joinToString(","))
    }


###  filter、takeWhile ###
    fun main(args: Array<String>) {
        //从1到100中过滤出%2==0
        (1..100).filter { it % 2 == 0 }.forEach { println(it) }

        //takeWhile 则返回的集合是原集合中从第一个元素开始到第一个不符合条件的元素之前的所有元素
        (1..100).takeWhile { it % 10 !=0 }.forEach { println(it) }
    }


### let ###
    //调用某对象的let函数，则该对象为函数的参数。在函数块内可以通过 it 指代该对象。返回值为函数块的最后一行或指定return表达式。
    fun main(args: Array<String>) {
        val person: Person? = Person()
        println(person)

        //java
        if (null != person) {
            person.name = "kobe"
            person.age = 38
            println(person)
        }

        //to kotlin
        var let = person?.let {
            person.name = "kobe"
            person.age = 38
            println(person)
            "111"
        }
        println(let)

        println(testLet())
    }

    data class Person(var name: String? = null, var age: Int = 0)


    fun testLet(): Int {
        // fun <T, R> T.let(block: (T) -> R): R = block(this)
        "testLet".let {
            println(it)
            return 1
        }
    }


## 几个常用注解 ##
Java调用Kotlin时

- @JvmField 将属性编译为Java变量
- @JvmStatic 将对象的方法编译为Java静态方法
- @JvmOverloads  默认参数生成重载方法
- @JvmName 指定Kotlin文件编译后的类名
