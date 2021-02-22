package main

import (
	"fmt"
	"strings"
)

type Node struct {
	value int
	// keep track of key for hashmap eviction.
	key  int
	next *Node
	prev *Node
}

type LRUCache struct {
	capacity int
	T        map[int]*Node
	start    *Node
	end      *Node
}

func Constructor(capacity int) LRUCache {
	return LRUCache{
		capacity: capacity,
		T:        make(map[int]*Node),
	}
}

// If key in hashmap, move node to front and return its value, else return -1.
func (c *LRUCache) Get(key int) int {
	if node, ok := c.T[key]; ok {
		c.remove(node)
		c.addToFront(node)
		fmt.Printf("return %d\n", node.value)
		return node.value
	}
	fmt.Println("return -1 (not found)")
	return -1
}

// If key in hashmap, update node value and move it to front.
// Else create the node and add it to front. If capacity reached, remove the end node.
func (c *LRUCache) Put(key int, value int) {
	evictMsg := ""

	if node, ok := c.T[key]; ok {
		node.value = value
		c.remove(node)
		c.addToFront(node)
		fmt.Println(c.toString())
		return
	}

	if len(c.T) == c.capacity {
		evictMsg = fmt.Sprintf("LRU key was %d, evicts key %d, ", c.end.key, c.end.key)
		delete(c.T, c.end.key)
		c.remove(c.end)
	}
	c.T[key] = &Node{
		value: value,
		key:   key,
	}
	c.addToFront(c.T[key])
	fmt.Printf("%s%s\n", evictMsg, c.toString())
}

// Set node.prev, node.next to nil, c.start.
// If start is not nil, set start.prev to node.
// Set start to node, and set end to node if end is nil.
func (c *LRUCache) addToFront(node *Node) {
	node.next = c.start
	node.prev = nil

	if c.start != nil {
		c.start.prev = node
	}
	c.start = node

	if c.end == nil {
		c.end = node
	}
}

// If c.start is node, set c.start to node.next. Else set node.prev.next to node.next.
// If c.end is node, set c.end to node.prev. Else set node.next.prev to node.prev
func (c *LRUCache) remove(node *Node) {
	if c.start == node {
		c.start = node.next
	} else {
		node.prev.next = node.next
	}

	if c.end == node {
		c.end = node.prev
	} else {
		node.next.prev = node.prev
	}
}

func (c *LRUCache) toString() string {
	s := "cache is {%s}"
	var cacheSB strings.Builder

	current := c.start
	for true {
		if current == nil {
			break
		}
		cacheSB.WriteString(fmt.Sprintf("%d=%d", current.key, current.value))

		if current.next != nil {
			cacheSB.WriteString(",")
		}
		current = current.next
	}
	return fmt.Sprintf(s, cacheSB.String())
}

func main() {
	cache := Constructor(3)
	cache.Put(1, 1)
	cache.Put(2, 2)
	cache.Get(1)
	cache.Put(3, 3)
	cache.Get(2)
	cache.Put(4, 4)
	cache.Get(1)
	cache.Get(3)
	cache.Get(4)
	cache.Put(4, 5)
	cache.Put(1, 5)
}
