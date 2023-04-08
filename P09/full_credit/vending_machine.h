#ifndef VEND_H
#define VEND_H
#include <string>
#include "item.h"

void add(std::string name, int price);
void buy(int index);
std::string menu();

class vending_machine{

    private:
    std::vector<Item> items;

    public:
    void add(std::string name, int price);

    void buy(int index);

    std::string menu();

};

#endif