package com.example.cxh.kotlinstudy.kotlin.kt10_sealed


fun main(args: Array<String>) {
    val player: Player = Player()
    player.play("http://ws.stream.qqmusic.qq.com/C2000012Ppbd3hjGOK.m4a")
    player.pause()
    player.resume()
    player.seekTo(30000)
    player.stop()
}