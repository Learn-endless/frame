//生成验证码函数
//参数一：选择器字符串，如：#canvas
//参数二：验证码的宽
//参数三：验证码的高
function captcha(canva,width,height){

    // 生成一个随机数
    function randomNumber(min,max){
        return parseInt(Math.random()*(max-min)+min);
    }

    // 随机生成颜色(带透明度)
    function randomColor(min,max){
        let r = randomNumber(min,max);
        let g = randomNumber(min,max);
        let b = randomNumber(min,max);
        let a = Math.random()*0.6+0.6;
        return "rgba("+r+","+g+","+b+","+a+")";
    }

    let canvas = document.querySelector(canva);
    //拿到2d画笔
    let print = canvas.getContext('2d');
    //清除一下画布内容
    print.clearRect(0,0,width,height);
    //绘制背景颜色
    print.fillStyle = randomColor(130,200);
    print.fillRect(0,0,width,height);

    //随机字符串
    let str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";

    //存放每次随机的值
    let result = "";
    for(let i = 0; i < 6; i++){
        //随机的每个字符
        let ch = str[randomNumber(0,str.length)];
        //将值添加到s中
        result += ch;
        //随机字体的大小
        let fontSize = randomNumber(50,120);
        //随机字符的旋转角度
        let angle = randomNumber(-40,40);
        //给画笔设置属性
        print.font = fontSize +'px Simhei';
        print.textBaseline = 'top';
        //设置字体的填充颜色
        print.fillStyle = randomColor(80,150);
        print.save();
        print.translate(40*i+50,50);
        print.rotate(angle*Math.PI/180);
        print.fillText(ch,-15,-15);
        print.restore();
        // console.log(ch);
    }

    //随机生成干扰线
    for(let i = 0; i < 15; i++){
        print.beginPath();
        print.moveTo(randomNumber(0,width),randomNumber(0,height));
        print.lineTo(randomNumber(0,width),randomNumber(0,height));
        print.strokeStyle = randomColor(180,230);
        print.lineWidth = 3;
        print.closePath();
        print.stroke();
    }

    //随机生成50个干扰点
    for(let i = 0; i < 40; i++){
        print.beginPath();
        print.arc(randomNumber(0,width),randomNumber(0,height),4,0,2*Math.PI);
        print.closePath();
        print.fillStyle = randomColor(150,200);
        print.fill();
    }

    return result;
}