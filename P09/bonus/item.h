#ifndef ITEM_H
#define ITEM_H
#include <string>

class Item{

    friend std::ostream& operator << (std::ostream& os, const Item& Item);
    friend std::istream& operator >> (std::istream& is, Item& Item);

    private:
    std::string _name;
    int _price;

    public:
    Item();
    Item(std::string name, int price);

};

#endif