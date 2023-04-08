#ifndef VEND_H
#define VEND_H
#include <string>
#include "item.h"

class vending_machine{

    friend std::ostream& operator << (std::ostream& os, const vending_machine& vending);

    private:
    std::vector<Item> items;

    public:
    void add(std::string name, int price);

    void buy(int index);

};

#endif