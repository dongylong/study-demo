//package kafka
//
//import com.okay.kafka.KafkaProduceMsg
//
///**
//  * Created by dongyl on 1/11/17.
//  */
//object ProduceMsg {
//  def main(args: Array[String]): Unit = {
//    if (args.length < 2) {
//      println("Usage : ProduceMsg 192.168.1.155:9092,192.168.1.155:9093 new")
//
//      System.exit(1)
//    }
//
//    new Thread(new KafkaProduceMsg(args(0), args(1))).start()
//  }
//}
